package ch.alika.springpractice.features.support.actor.domain;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.actor.IGreetingGetter;

public class GreetedActor implements IGreetingGetter {

    private final MoodCenter moodCenter;

    public GreetedActor(MoodCenter moodCenter) {
        this.moodCenter = moodCenter;
    }

    @Override
    public String getGreeting() {
        return moodCenter.getGreeting();
    }
}
