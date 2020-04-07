package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IGreetingSupplier;
import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;

public class SadStrategy implements IMoodStrategy {
    private Mood MOOD = new Mood("SAD","sad");

    @Override
    public Mood getMood() {
        return MOOD;
    }

    @Override
    public IGreetingSupplier getGreetingSupplier() {
        return () -> "Please go away :-(";
    }
}
