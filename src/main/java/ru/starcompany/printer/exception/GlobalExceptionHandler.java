package ru.starcompany.printer.exception;

import org.jetbrains.annotations.NotNull;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        String errorMessage = constraintViolationException.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(@NotNull HttpMessageNotReadableException ex,
                                                                  @NotNull HttpHeaders headers, @NotNull HttpStatusCode status,
                                                                  @NotNull WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Не передано или передано некорректное тело запроса");
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(@NotNull MissingServletRequestParameterException ex,
                                                                          @NotNull HttpHeaders headers, @NotNull HttpStatusCode status,
                                                                          @NotNull WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Не передан обязательный параметр " + ex.getParameterName());
    }

}
