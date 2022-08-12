package org.aibles.worker2.exeption.handle;

import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.exeption.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.BadLocationException;
import java.lang.module.ResolutionException;
import java.time.Instant;

@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Slf4j
public class InternalServerExceptionHandle {
    @ExceptionHandler(BadLocationException.class)
    public ExceptionResponse resourceNoFoundExceptionHandle(ResolutionException error) {
        log.info("Exception: error:{}, message: {}",HttpStatus.BAD_REQUEST.value(), error.getMessage());
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setError("Server Error!!");
        exceptionResponse.setMessage(error.getMessage());
        exceptionResponse.setTimeStamp(Instant.now());
        return exceptionResponse;
    }
}
