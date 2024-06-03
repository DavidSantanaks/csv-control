package com.project.csv_controll.service;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.UnexpectedErrorWhenReadCsvFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReadCsvService {

    List<PersonDTO> readCSVAndOrderByFirstName(MultipartFile file) throws UnexpectedErrorWhenReadCsvFile;
}
