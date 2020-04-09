package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class AbstractMoodStrategyTests {
    private IMoodStrategy moodStrategy;

    protected AbstractMoodStrategyTests(IMoodStrategy moodStrategy) {
        this.moodStrategy = moodStrategy;
    }

    protected abstract Mood expectedMood();

    protected abstract String expectedGreeting();

    @Test
    public void shouldProvideMood() {
        assertThat(getMood(),is(expectedMood()));
    }

    @Test
    public void shouldProvideGreeting() {
        assertThat(getGreeting(),is(expectedGreeting()));
    }

    private Mood getMood() {
        return moodStrategy.getMood();
    }

    private String getGreeting() {
        return moodStrategy.getGreeting();
    }
}
