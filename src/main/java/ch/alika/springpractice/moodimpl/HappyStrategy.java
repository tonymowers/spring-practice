package ch.alika.springpractice.moodimpl;

import ch.alika.springpractice.domain.IGreetingSupplier;
import ch.alika.springpractice.domain.IMoodStrategy;
import ch.alika.springpractice.domain.Mood;

public class HappyStrategy implements IMoodStrategy {
    private Mood MOOD = new Mood("HAPPY","happy");

    private IGreetingSupplier greetingSupplier = new GreetingSupplier();

    @Override
    public Mood getMood() {
        return MOOD;
    }

    @Override
    public IGreetingSupplier getGreetingSupplier() {
        return greetingSupplier;
    }

    private class GreetingSupplier implements IGreetingSupplier {

        @Override
        public String getGreeting() {
            return "Howdy!";
        }
    }
}
