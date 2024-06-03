package com.project.csv_controll.proxy;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.CsvFileDateTimeParseException;
import com.project.csv_controll.exception.UnexpectedErrorWhenReadCsvFile;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface IProcessCsvProxy {

    List<PersonDTO> processPersonCsv(MultipartFile csvFile, Model requestModel) throws UnexpectedErrorWhenReadCsvFile, CsvFileDateTimeParseException;
}
