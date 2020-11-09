package com.fidrs.printer.service;

import com.fidrs.printer.exceptions.PrinterException;
import com.fidrs.printer.views.PrinterAvailableDTO;

import java.util.List;

public interface PrinterService {
    List<PrinterAvailableDTO> findAllAvailable() throws PrinterException;
}
