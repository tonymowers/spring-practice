package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HappyMoodTests {
    private IMoodStrategy moodStrategy = new HappyMood();

    @BeforeEach
    void beforeEach() {

    }

    @Test
    public void shouldProvideMood() {
        Mood HAPPY_MOOD = new Mood("HAPPY","happy");
        assertThat(moodStrategy.getMood(),is(HAPPY_MOOD));
    }

    @Test
    public void shouldProvideGreeting() {
        assertThat(getGreeting(),is("Howdy!"));
    }

    private String getGreeting() {
        return moodStrategy.getGreetingSupplier().getGreeting();
    }
}
