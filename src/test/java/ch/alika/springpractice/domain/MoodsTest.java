package ch.alika.springpractice.domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static ch.alika.springpractice.domain.Moods.NULL_MOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoodsTest {
    private static final int SIMPLE_ID = 0;
    private static final String SIMPLE_NAME = "SIMPLE";
    private static final Mood SIMPLE_MOOD = Moods.createSimpleMood(0, SIMPLE_NAME);

    @Test
    public void whereSimpleMoodCreated() {
        assertThat(SIMPLE_MOOD.getId(),is(SIMPLE_ID));
        assertThat(SIMPLE_MOOD.getName(),is(SIMPLE_NAME));
    }

    @Test
    public void whereNullMoodUsed() {
        assertThat(NULL_MOOD.getId(),is(-1));
        assertThat(NULL_MOOD.getName(),is("NULL"));
        assertThat(NULL_MOOD,is(Matchers.not(SIMPLE_MOOD)));
    }
}
