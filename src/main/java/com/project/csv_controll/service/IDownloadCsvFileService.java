package com.project.csv_controll.service;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.DownloadCsvUnexpectedException;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public interface IDownloadCsvFileService {

    void download(HttpServletResponse response, List<PersonDTO> listToDownload) throws DownloadCsvUnexpectedException;
}
