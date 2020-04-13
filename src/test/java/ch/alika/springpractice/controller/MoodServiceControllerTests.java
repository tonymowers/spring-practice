package ch.alika.springpractice.controller;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.dto.MoodChangeRequestDTO;
import ch.alika.springpractice.dto.MoodOverviewDTO;
import ch.alika.springpractice.service.impl.MoodService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MoodServiceControllerTests {
    private static final Mood HAPPY_MOOD = new Mood("HAPPY", "happy");
    private static final Mood SAD_MOOD = new Mood("SAD", "sad");

    @Mock
    private MoodCenter moodCenter;
    private MoodServiceController moodServiceController;

    @BeforeEach
    void beforeEach() {
        moodServiceController = new MoodServiceController(new MoodService(moodCenter));
    }

    @Test
    void whereGetCurrentMood() {
        // Given
        when(moodCenter.getCurrentMood()).thenReturn(HAPPY_MOOD);

        // When
        ResponseEntity<Mood> response = moodServiceController.getCurrentMood();

        // Then
        assertThat(response.getBody(), is(HAPPY_MOOD));
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    void whereUpdateCurrentMood() {
        // When
        ResponseEntity<String> response = moodServiceController.updateCurrentMood(fromMood());

        // Then
        assertThat(response.getBody(), is("Current mood updated successfully"));
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        verify(moodCenter).setCurrentMoodById(HAPPY_MOOD.getId());
    }

    @Test
    void whereGetMoodOverview() {
        // Given
        final MoodOverviewDTO moodOverview = new MoodOverviewDTO(HAPPY_MOOD, SAD_MOOD, Arrays.asList(HAPPY_MOOD, SAD_MOOD));
        when(moodCenter.getCurrentMood()).thenReturn(moodOverview.getCurrentMood());
        when(moodCenter.getDefaultMood()).thenReturn(moodOverview.getDefaultMood());
        when(moodCenter.getAvailableMoods()).thenReturn(moodOverview.getAllMoods());

        // When
        ResponseEntity<MoodOverviewDTO> response = moodServiceController.getMoodOverview();

        // Then
        assertThat(response.getBody(), is(moodOverview));
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    private MoodChangeRequestDTO fromMood() {
        MoodChangeRequestDTO moodChangeRequest = new MoodChangeRequestDTO();
        moodChangeRequest.setNewMoodId(HAPPY_MOOD.getId());
        return moodChangeRequest;
    }
}
