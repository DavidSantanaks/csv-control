package com.project.csv_controll.service.impl;

import com.opencsv.CSVWriter;
import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.DownloadCsvUnexpectedException;
import com.project.csv_controll.service.IDownloadCsvFileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class DownloadCsvFileServiceImpl implements IDownloadCsvFileService {

    private static final String UNEXPECTED_ERROR_WHEN_DOWNLOAD_FILE = "Ocorreu um erro ao tentar realizar download do arquivo CSV, detalhes: %s";
    private static final String CSV_CONTENT_TYPE = "text/csv";
    private static final String CONTENT_KEY_HEADER = "Content-Disposition";
    private static final String CONTENT_KEY_VALUE = "attachment; filename=\"updated_file.csv\"";
    private static final String[] CSV_HEADERS = new String[]{"Nome", "SobreNome", "Email", "Sexo", "IpAcesso", "Idade", "Nascimento"};

    @Override
    public void download(HttpServletResponse response, List<PersonDTO> listToDownload) throws DownloadCsvUnexpectedException {
        response.setContentType(CSV_CONTENT_TYPE);
        response.setHeader(CONTENT_KEY_HEADER, CONTENT_KEY_VALUE);
        try (CSVWriter writer = new CSVWriter(response.getWriter())) {
            writer.writeNext(CSV_HEADERS);
            for (PersonDTO personDTO : listToDownload) {
                writer.writeNext(new String[]{
                        personDTO.getFirstName(),
                        personDTO.getSurname(),
                        personDTO.getEmail(),
                        personDTO.getGender(),
                        personDTO.getAccessIp(),
                        String.valueOf(personDTO.getAge()),
                        personDTO.getBirthDate()});
            }
        } catch (IOException e) {
            throw new DownloadCsvUnexpectedException(String.format(UNEXPECTED_ERROR_WHEN_DOWNLOAD_FILE, e.getMessage()));
        }
    }
}
