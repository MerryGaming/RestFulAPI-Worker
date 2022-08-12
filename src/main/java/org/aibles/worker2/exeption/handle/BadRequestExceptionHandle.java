package org.aibles.worker2.exeption.handle;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.exeption.BadRequestException;
import org.aibles.worker2.exeption.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.BadLocationException;
import java.time.Instant;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class BadRequestExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse badRequestExceptionHandle(MethodArgumentNotValidException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        List<String> errors = new ArrayList<>();
        e.getBindingResult()
            .getFieldErrors()
            .forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));

        log.info("Exception: error:{}, message: {}",HttpStatus.BAD_REQUEST.value(), e.getMessage());
        ExceptionResponse exceptionReponse = new ExceptionResponse();
        exceptionReponse.setError("Bad Error");
        exceptionReponse.setMessage(e.toString());
        exceptionReponse.setTimeStamp(Instant.now());
        return exceptionReponse;
    }
}
