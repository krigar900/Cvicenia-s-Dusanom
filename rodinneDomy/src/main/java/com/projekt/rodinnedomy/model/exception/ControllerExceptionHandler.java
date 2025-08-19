package com.projekt.rodinnedomy.model.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Global Exception handler for every kind of exception
 * As response is formatted error message.
 */
@SuppressWarnings("unused")
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Environment environment;


    /**
     * Spring Boot, spring boot -> org.springframework.dao
     * PK-FK issue -> DataIntegrityViolationException
     * @param ex exc
     * @param request req
     */
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException ex, HttpServletRequest request) {

        ErrorResponse message = new ErrorResponse(
                3000,
                "1234",
                "System Alert: An unexpected database error has occurred. Please contact support for assistance.",
                ex.getMessage()+", "+(ex.getCause()!=null? ex.getCause().getMessage() : ""));

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientExceptionHandler(HttpClientErrorException ex, HttpServletRequest request) {
        ErrorResponse message = new ErrorResponse(
                5568,
                "1234",
                "Code:"+ex.getStatusCode()+", "+ex.getStatusText());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Any other uncaught Exception
     * @param ex exc
     * @param request req
     * @return formatted error message in response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        ErrorResponse message = new ErrorResponse(
                2000,
                "1234",
                "System Alert: An unexpected error has occurred. Please contact support for assistance.",
                ex.getMessage());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
