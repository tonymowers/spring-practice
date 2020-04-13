package ch.alika.springpractice.dto;

import lombok.Value;

import java.util.Date;

@Value
public class ExceptionResponseDTO {
    Date timestamp;
    String message;
    String details;
}