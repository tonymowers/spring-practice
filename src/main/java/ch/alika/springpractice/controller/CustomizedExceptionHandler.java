package ch.alika.springpractice.controller;

import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
                new Date(),ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MoodNotFoundException.class)
    public final ResponseEntity<Object> handleObjectNotFouncException(Exception ex, WebRequest request) {
        ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(
                new Date(),ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
