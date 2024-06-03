package com.project.csv_controll.proxy.impl;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.dto.StatisticsAveragePersonDTO;
import com.project.csv_controll.exception.CsvFileDateTimeParseException;
import com.project.csv_controll.exception.UnexpectedErrorWhenReadCsvFile;
import com.project.csv_controll.mapper.impl.PersonMapper;
import com.project.csv_controll.proxy.IProcessCsvProxy;
import com.project.csv_controll.service.IPersonCsvHandlerService;
import com.project.csv_controll.service.IReadCsvService;
import com.project.csv_controll.service.ISavePersonService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Component
public class ProcessCsvProxyImpl implements IProcessCsvProxy {

    private final IReadCsvService readCsvService;
    private final IPersonCsvHandlerService personCsvHandlerService;
    private final ISavePersonService savePersonService;
    private final PersonMapper personMapper;

    private static final String PEOPLE_ATTRIBUTE_NAME = "people";
    private static final String STATISTICS_ATTRIBUTE_NAME = "statisticsAveragePerson";

    public ProcessCsvProxyImpl(IReadCsvService readCsvService, IPersonCsvHandlerService personCsvHandlerService, ISavePersonService savePersonService, PersonMapper personMapper) {
        this.readCsvService = readCsvService;
        this.personCsvHandlerService = personCsvHandlerService;
        this.savePersonService = savePersonService;
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonDTO> processPersonCsv(MultipartFile csvFile, Model requestModel) throws UnexpectedErrorWhenReadCsvFile, CsvFileDateTimeParseException {
        List<PersonDTO> peopleListToUpdate = this.readCsvService.readCSVAndOrderByFirstName(csvFile);
        this.personCsvHandlerService.fixDateOfBirth(peopleListToUpdate);
        StatisticsAveragePersonDTO statisticsAveragePersonDTO = this.personCsvHandlerService.countGendersAndCalculateAverageAge(peopleListToUpdate);
        requestModel.addAttribute(PEOPLE_ATTRIBUTE_NAME, peopleListToUpdate);
        requestModel.addAttribute(STATISTICS_ATTRIBUTE_NAME, statisticsAveragePersonDTO);
        peopleListToUpdate.forEach(personDto ->{
            this.savePersonService
                    .save(this.personMapper.dtoToEntity(personDto));
        });
        return peopleListToUpdate;
    }
}
