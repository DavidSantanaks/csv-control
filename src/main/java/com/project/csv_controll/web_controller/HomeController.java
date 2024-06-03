package com.project.csv_controll.web_controller;

import com.project.csv_controll.dto.PersonDTO;
import com.project.csv_controll.exception.CsvFileDateTimeParseException;
import com.project.csv_controll.exception.DownloadCsvUnexpectedException;
import com.project.csv_controll.exception.UnexpectedErrorWhenReadCsvFile;
import com.project.csv_controll.proxy.IProcessCsvProxy;
import com.project.csv_controll.service.IDownloadCsvFileService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
public class HomeController {

    private final IProcessCsvProxy processCsvProxy;
    private final IDownloadCsvFileService downloadCsvFileService;
    private List<PersonDTO> people;

    public HomeController(IProcessCsvProxy processCsvProxy, IDownloadCsvFileService downloadCsvFileService) {
        this.processCsvProxy = processCsvProxy;
        this.downloadCsvFileService = downloadCsvFileService;
    }

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @PostMapping("/home")
    public String csvUpload(@RequestParam("file") MultipartFile file, Model model) throws CsvFileDateTimeParseException, UnexpectedErrorWhenReadCsvFile {
        if (file.isEmpty()) {
            return "home";
        }
        people = this.processCsvProxy.processPersonCsv(file, model);
        return "home";
    }

    @GetMapping("/download-csv")
    public void csvDownload(HttpServletResponse response) throws DownloadCsvUnexpectedException {
        this.downloadCsvFileService.download(response, people);
    }
}
