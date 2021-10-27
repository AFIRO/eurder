package com.switchfully.eurder.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ValidationControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ValidationControllerExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws Exception{
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(AuthorisationException.class)
    protected void authorisationException(AuthorisationException exception, HttpServletResponse response) throws Exception{
        logger.error(exception.getMessage());
        response.sendError(HttpStatus.FORBIDDEN.value(), exception.getMessage());
    }

}
