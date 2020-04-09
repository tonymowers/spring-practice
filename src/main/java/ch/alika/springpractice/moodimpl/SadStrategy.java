package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;

public class SadStrategy implements IMoodStrategy {
    private static final Mood MOOD = new Mood("SAD","sad");

    @Override
    public Mood getMood() {
        return MOOD;
    }

    @Override
    public String getGreeting() {
        return "Please go away :-(";
    }
}
