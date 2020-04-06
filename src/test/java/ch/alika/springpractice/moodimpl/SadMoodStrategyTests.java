package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.Mood;

public class SadMoodStrategyTests extends AbstractMoodStrategyTests {

    public SadMoodStrategyTests() {
        super(new SadMoodStrategy());
    }

    @Override
    protected Mood expectedMood() {
        return new Mood("SAD","sad");
    }

    @Override
    protected String expectedGreeting() {
        return "Please go away :-(";
    }
}
