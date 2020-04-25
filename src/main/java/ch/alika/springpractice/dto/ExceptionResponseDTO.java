package ch.alika.springpractice.dto;

import lombok.NonNull;
import lombok.Value;

import java.util.Date;

@Value
public class ExceptionResponseDTO {
    @NonNull Date timestamp;
    @NonNull String message;
    @NonNull String details;
}