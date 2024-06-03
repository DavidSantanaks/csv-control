package com.project.csv_controll.service;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.dto.StatisticsAveragePersonDTO;
import com.project.csv_controll.exception.CsvFileDateTimeParseException;

import java.util.List;

public interface IPersonCsvHandlerService {

    void fixDateOfBirth(List<PersonDTO> people) throws CsvFileDateTimeParseException;
    StatisticsAveragePersonDTO countGendersAndCalculateAverageAge(List<PersonDTO> people);
}
