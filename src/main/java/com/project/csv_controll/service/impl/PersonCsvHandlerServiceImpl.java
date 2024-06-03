package com.project.csv_controll.service.impl;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.dto.StatisticsAveragePersonDTO;
import com.project.csv_controll.exception.CsvFileDateTimeParseException;
import com.project.csv_controll.service.IPersonCsvHandlerService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class PersonCsvHandlerServiceImpl implements IPersonCsvHandlerService {

    private static final String DATE_TIME_EXCEPTION_MESSAGE = "Ocorreu um erro ao converter a data no arquivo CSV, detalhes: %s";
    private static final String MALE_GENDER = "male";
    private static final String FEMALE_GENDER = "female";
    private static final String DATE_FORMAT_TO_FIX_DATE_OF_BIRTH = "dd/MM/yyyy";
    private static final String DEFAULT_VALUE_TO_DATE = "0";
    private static final String DEFAULT_STRING_TO_REGEX = "/";

    @Override
    public void fixDateOfBirth(List<PersonDTO> people) throws CsvFileDateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_TO_FIX_DATE_OF_BIRTH);
        for (PersonDTO personDTO : people) {
            try {
                String dateWithoutIncorrectYear = personDTO.getBirthDate().substring(0, personDTO.getBirthDate().lastIndexOf("/"));
                String[] dateParts = dateWithoutIncorrectYear.split(DEFAULT_STRING_TO_REGEX);
                if (dateParts[0].length() == 1) {
                    dateParts[0] = DEFAULT_VALUE_TO_DATE + dateParts[0];
                }
                if (dateParts[1].length() == 1) {
                    dateParts[1] = DEFAULT_VALUE_TO_DATE + dateParts[1];
                }
                LocalDate birthDate = LocalDate.parse(dateParts[0]+DEFAULT_STRING_TO_REGEX+dateParts[1]+DEFAULT_STRING_TO_REGEX+Year.now().getValue(), formatter);
                LocalDate newBirthDate = birthDate.minusYears(personDTO.getAge());
                personDTO.setBirthDate(newBirthDate.format(formatter));
            } catch (DateTimeParseException e) {
                throw new CsvFileDateTimeParseException(String.format(DATE_TIME_EXCEPTION_MESSAGE, e.getMessage()));
            }
        }
    }

    @Override
    public StatisticsAveragePersonDTO countGendersAndCalculateAverageAge(List<PersonDTO> people) {
        int maleCount = 0;
        int femaleCount = 0;
        int maleAgeSum = 0;
        int femaleAgeSum = 0;
        int maleAgeCount = 0;
        int femaleAgeCount = 0;
        for (PersonDTO personDTO : people) {
            if (personDTO.getGender().equalsIgnoreCase(MALE_GENDER)) {
                maleCount++;
                maleAgeSum += personDTO.getAge();
                maleAgeCount++;
            } else if (personDTO.getGender().equalsIgnoreCase(FEMALE_GENDER)) {
                femaleCount++;
                femaleAgeSum += personDTO.getAge();
                femaleAgeCount++;
            }
        }
        double maleAverageAge = maleAgeCount > 0 ? (double) maleAgeSum / maleAgeCount : 0;
        double femaleAverageAge = femaleAgeCount > 0 ? (double) femaleAgeSum / femaleAgeCount : 0;
        return new StatisticsAveragePersonDTO(maleCount, femaleCount, maleAgeSum, femaleAgeSum, maleAgeCount, femaleAgeCount, maleAverageAge, femaleAverageAge);
    }
}
