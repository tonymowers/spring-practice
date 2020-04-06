package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.Mood;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HappyMoodStrategyTests extends AbstractMoodStrategyTests {

    public HappyMoodStrategyTests() {
        super(new HappyMoodStrategy());
    }

    @Override
    protected Mood expectedMood() {
        return new Mood("HAPPY","happy");
    }
    @Override
    protected String expectedGreeting() {
        return "Howdy!";
    }

}
