package com.fidrs.printer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PrinterException extends Throwable {

    private HttpStatus status;
    private String message;
    private String code;

    public PrinterException(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public Map<String, Object> toResponse() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", this.code);
        map.put("message", this.message);
        return map;
    }

}
