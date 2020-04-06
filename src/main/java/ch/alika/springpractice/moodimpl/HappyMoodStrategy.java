package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IGreetingSupplier;
import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;

public class HappyMoodStrategy implements IMoodStrategy {
    private Mood MOOD = new Mood("HAPPY","happy");

    @Override
    public Mood getMood() {
        return MOOD;
    }

    @Override
    public IGreetingSupplier getGreetingSupplier() {
        return () -> "Howdy!";
    }
}
