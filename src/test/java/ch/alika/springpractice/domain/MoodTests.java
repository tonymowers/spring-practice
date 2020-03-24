package ch.alika.springpractice.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static ch.alika.springpractice.domain.Mood.NULL_MOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoodTests {
    private static final String SIMPLE_ID = "SIMPLE";
    private static final String SIMPLE_NAME = "SIMPLE";
    private static final Mood SIMPLE_MOOD = new Mood(SIMPLE_ID, SIMPLE_NAME);

    @Test
    public void whereSimpleMoodCreated() {
        assertThat(SIMPLE_MOOD.getId(),is(SIMPLE_ID));
        assertThat(SIMPLE_MOOD.getName(),is(SIMPLE_NAME));
    }

    @Test
    public void whereNullMoodUsed() {
        assertThat(NULL_MOOD.getId(),is("NULL"));
        assertThat(NULL_MOOD.getName(),is("NULL"));
        assertThat(NULL_MOOD,is(Matchers.not(SIMPLE_MOOD)));
    }
}
