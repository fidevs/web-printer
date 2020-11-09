package com.fidrs.printer.service.impl;

import com.fidrs.printer.exceptions.PrinterException;
import com.fidrs.printer.service.PrinterService;
import com.fidrs.printer.utils.Constants;
import com.fidrs.printer.views.PrinterAvailableDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PrinterServiceImpl implements PrinterService {

    @Override
    public List<PrinterAvailableDTO> findAllAvailable() throws PrinterException {
        final String os = System.getProperty(Constants.OPERATIVE_SYSTEM_NAME);
        log.info("Operative System: {}", os);

        PrintService[] ps = PrintServiceLookup.lookupPrintServices(null, null);
        log.info("Found {} PrintServices", ps.length);

        for (PrintService p : ps) {
            log.info("PrintService: {}", p);
        }

        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        log.info("Default printer: {}", service);

        return new ArrayList<>();
    }

}
