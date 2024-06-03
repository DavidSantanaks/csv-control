package com.project.csv_controll.service.impl;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.UnexpectedErrorWhenReadCsvFile;
import com.project.csv_controll.service.IReadCsvService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ReadCsvServiceImpl implements IReadCsvService {

    private static final String UNEXPECTED_ERROR_READ_CSV_MESSAGE = "Ocorreu um erro ao ler o arquivo CSV %s, detalhes: %s";

    private static final int NAME_INDEX = 0;
    private static final int SURNAME_INDEX = 1;
    private static final int EMAIL_INDEX = 2;
    private static final int GENDER_INDEX = 3;
    private static final int ACCESS_IP_INDEX = 4;
    private static final int AGE_INDEX = 5;
    private static final int DATE_OF_BIRTH_INDEX = 6;

    @Override
    public List<PersonDTO> readCSVAndOrderByFirstName(MultipartFile file) throws UnexpectedErrorWhenReadCsvFile {
        List<PersonDTO> people = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String name = parts[NAME_INDEX].replace("\"", "").trim();
                    String surname = parts[SURNAME_INDEX].trim();
                    String email = parts[EMAIL_INDEX].trim();
                    String gender = parts[GENDER_INDEX].trim();
                    String accessIp = parts[ACCESS_IP_INDEX].trim();
                    int age = Integer.parseInt(parts[AGE_INDEX].trim());
                    String dateOfBirth = parts[DATE_OF_BIRTH_INDEX].replace("\"", "").trim();
                    people.add(new PersonDTO(name, surname, email, gender, accessIp, age, dateOfBirth));
                }
            }
        } catch (Exception e) {
            throw new UnexpectedErrorWhenReadCsvFile(String.format(UNEXPECTED_ERROR_READ_CSV_MESSAGE, file.getName(), e.getMessage()));
        }
        // Ordenar os dados pelo nome
        people.sort(Comparator.comparing(PersonDTO::getFirstName));
        return people;
    }
}
