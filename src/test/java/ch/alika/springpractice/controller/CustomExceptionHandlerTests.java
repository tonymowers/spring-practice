package ch.alika.springpractice.controller;

import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.dto.ExceptionResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomExceptionHandlerTests {
    private static final String REQUEST_DETAILS = "uri=/some-url";
    private static final String EXCEPTION_MESSAGE = "message";

    private CustomExceptionHandler exceptionHandler;

    @BeforeEach
    void beforeEach() {
        this.exceptionHandler = new CustomExceptionHandler();
    }

    @Test
    void whereUnknownException() {
        // Given
        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn(REQUEST_DETAILS);

        // When
        ResponseEntity<ExceptionResponseDTO> response = exceptionHandler.handleAllExceptions(new RuntimeException(EXCEPTION_MESSAGE), webRequest);

        // Then
        ExceptionResponseDTO exceptionResponse = response.getBody();
        assertThat(exceptionResponse,is(notNullValue()));
        assertThat(exceptionResponse.getDetails(), is(REQUEST_DETAILS));
        assertThat(exceptionResponse.getMessage(), is(EXCEPTION_MESSAGE));
        assertThat(exceptionResponse.getTimestamp(), is(notNullValue()));
        assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Test
    void whereMoodNotFoundException() {
        // Given
        WebRequest webRequest = mock(WebRequest.class);
        when(webRequest.getDescription(false)).thenReturn(REQUEST_DETAILS);

        // When
        ResponseEntity<ExceptionResponseDTO> response = exceptionHandler.handleMoodNotFoundException(new MoodNotFoundException(EXCEPTION_MESSAGE), webRequest);

        // Then
        ExceptionResponseDTO exceptionResponse = response.getBody();
        assertThat(exceptionResponse,is(notNullValue()));
        assertThat(exceptionResponse.getDetails(), is(REQUEST_DETAILS));
        assertThat(exceptionResponse.getMessage(), is(EXCEPTION_MESSAGE));
        assertThat(exceptionResponse.getTimestamp(), is(notNullValue()));
        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

}
