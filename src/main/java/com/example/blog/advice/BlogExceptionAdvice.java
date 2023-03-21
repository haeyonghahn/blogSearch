package com.example.blog.advice;

import com.example.blog.exception.ErrorCode;
import com.example.blog.exception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BlogExceptionAdvice.class);

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
        logger.error("handleBindException", e.getMessage());
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.error("IllegalArgumentException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.ILLEGAL_ARGUMENT, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception e) {
        logger.error("exception", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.EXCEPTION, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
