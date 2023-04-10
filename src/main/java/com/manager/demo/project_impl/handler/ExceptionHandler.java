package com.manager.demo.project_impl.handler;

import com.manager.demo.project_impl.exception.ProjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ProjectNotFoundException.class)
    public String handleException(RuntimeException exception) {
        log.info("Caught exception: {}", exception.toString());
        return exception.getLocalizedMessage();
    }
}
