package com.example.retailer.exception;

import com.example.retailer.response.RetailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sujesh Shahi on  12/23/2022
 */
@ControllerAdvice
public class RetailExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RetailExceptionHandler.class);

    @ExceptionHandler(RetailException.class)
    public ResponseEntity<?> retailExceptionHandler(RetailException error) {

        logger.error("error::SB Exception::{}", error.getMessage());
        return RetailResponse.failResponseWithStatus(HttpStatus.BAD_REQUEST, error.getMessage());
    }

}
