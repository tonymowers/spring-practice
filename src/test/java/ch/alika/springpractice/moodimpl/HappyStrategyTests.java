package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.Mood;

public class HappyStrategyTests extends AbstractMoodStrategyTests {

    public HappyStrategyTests() {
        super(new HappyStrategy());
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
