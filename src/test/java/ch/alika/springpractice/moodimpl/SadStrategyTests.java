package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.Mood;

public class SadStrategyTests extends AbstractMoodStrategyTests {

    public SadStrategyTests() {
        super(new SadStrategy());
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
