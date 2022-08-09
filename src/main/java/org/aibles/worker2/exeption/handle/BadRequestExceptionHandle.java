package org.aibles.worker2.exeption.handle;

import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.exeption.BadRequestException;
import org.aibles.worker2.exeption.response.ExceptionReponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.BadLocationException;
import java.time.Instant;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class BadRequestExceptionHandle {
    @ExceptionHandler(BadLocationException.class)
    public ExceptionReponse badRequestExceptionHandle(BadRequestException error) {
        log.info("Exception: error:{}, message: {}",HttpStatus.BAD_REQUEST.value(), error.getMessage());
        ExceptionReponse exceptionReponse = new ExceptionReponse();
        exceptionReponse.setError("Bad Error");
        exceptionReponse.setMessage(error.getMessage());
        exceptionReponse.setTimeStamp(Instant.now());
        return exceptionReponse;
    }
}
