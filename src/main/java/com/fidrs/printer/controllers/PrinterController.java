package com.fidrs.printer.controllers;

import com.fidrs.printer.exceptions.PrinterException;
import com.fidrs.printer.service.PrinterService;
import com.fidrs.printer.views.PrinterAvailableDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/printer")
public class PrinterController {

    private PrinterService printerService;

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", System.getProperty("os.name"));
    }

    @GetMapping("/available-list")
    public List<PrinterAvailableDTO> consulPrintersAvailable() throws PrinterException {
        log.info("Searching printers available...");

        return this.printerService.findAllAvailable();
    }

}
