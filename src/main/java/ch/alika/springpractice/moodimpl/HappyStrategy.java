package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;

public class HappyStrategy implements IMoodStrategy {
    private static final Mood MOOD = new Mood("HAPPY","happy");

    @Override
    public Mood getMood() {
        return MOOD;
    }

    @Override
    public String getGreeting() {
        return "Howdy!";
    }
}
