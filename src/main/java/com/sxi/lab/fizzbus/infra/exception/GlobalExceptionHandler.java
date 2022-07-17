package com.sxi.lab.fizzbus.infra.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ApiCallError<String>> handleNotFoundException(HttpServletRequest request,
                                                                        NotFoundException ex) {

        log.error("NotFoundException {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .status(NOT_FOUND)
                .body(new ApiCallError<>("Not found",
                        List.of(ex.getMessage())));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiCallError<String>> handleIllegalArgumentException(HttpServletRequest request,
                                                                               IllegalArgumentException ex) {

        log.error("IllegalArgumentException {} \n\n {}", request.getRequestURI(), ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(new ApiCallError<>("Illegal Arguments",
                        List.of(ex.getMessage())));
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiCallError<String>> handleValidationException(HttpServletRequest request,
                                                                          ValidationException ex) {

        log.error("ValidationException {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .badRequest()
                .body(new ApiCallError<>("Validation exception",
                        List.of(ex.getMessage())));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiCallError<String>> handleMissingServletRequestParameterException(HttpServletRequest request,
                                                                                              MissingServletRequestParameterException ex) {

        log.error("handleMissingServletRequestParameterException {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .badRequest()
                .body(new ApiCallError<>("Missing request parameter",
                        List.of(Objects.requireNonNull(ex.getMessage()))));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiCallError<Map<String, String>>> handleMethodArgumentTypeMismatchException(HttpServletRequest request,
                                                                                                       MethodArgumentTypeMismatchException ex) {

        log.error("handleMethodArgumentTypeMismatchException {}\n",
                request.getRequestURI(), ex);

        Map<String, String> details = new HashMap<>();
        details.put("paramName", ex.getName());
        details.put("paramValue", Objects.requireNonNullElse(ex.getValue(), "").toString());
        details.put("errorMessage", ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(new ApiCallError<>("Method argument type mismatch", List.of(details)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ApiCallError<Map<String, String>>> handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                                                   MethodArgumentNotValidException ex) {

        log.error("handleMethodArgumentNotValidException {}\n", request.getRequestURI(), ex);

        List<Map<String, String>> details = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, String> detail = new HashMap<>();
            detail.put("objectName", fieldError.getObjectName());
            detail.put("field", fieldError.getField());
            detail.put("rejectedValue", "" + fieldError.getRejectedValue());
            detail.put("errorMessage", fieldError.getDefaultMessage());
            details.add(detail);
        });

        return ResponseEntity
                .badRequest()
                .body(new ApiCallError<>("Method argument validation failed", details));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ResponseEntity<ApiCallError<String>> handleUnauthorizedException(HttpServletRequest request,
                                                                            HttpClientErrorException ex) {

        log.error("handleUnauthorizedException {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(new ApiCallError<>("Unauthorized Access, check your credentials!",
                        List.of(ex.getMessage() != null ? ex.getMessage() : "")));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiCallError<String>> handleInternalServerError(HttpServletRequest request, Exception ex) {

        log.error("handleInternalServerError {}\n", request.getRequestURI(), ex);

        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(new ApiCallError<>("Internal server error",
                        List.of(ex.getMessage())));
    }
}

@JsonRootName("ApiError")
record ApiCallError<T>(@JsonProperty("message") String message,
                       @JsonProperty("details") List<T> details) {
}
