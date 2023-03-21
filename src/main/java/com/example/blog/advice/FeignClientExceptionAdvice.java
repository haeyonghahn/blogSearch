package com.example.blog.advice;

import com.example.blog.exception.ErrorCode;
import com.example.blog.exception.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class FeignClientExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(FeignClientExceptionAdvice.class);
    private final ObjectMapper objectMapper;

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handlefeignException(FeignException ex) {
        String str = ex.contentUTF8();
        Map<String, String> responseMap;
        try {
            responseMap = objectMapper.readValue(str, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        logger.error("FeignException" + ex);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.ILLEGAL_ARGUMENT, responseMap.get("message"));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
