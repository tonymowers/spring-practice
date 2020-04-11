package ch.alika.springpractice.features.support.domain;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.IGreetedActor;

public class GreetedActor implements IGreetedActor {

    private final MoodCenter moodCenter;

    public GreetedActor(MoodCenter moodCenter) {
        this.moodCenter = moodCenter;
    }

    @Override
    public String getGreeting() {
        return moodCenter.getGreeting();
    }
}
