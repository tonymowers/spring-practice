package ch.alika.springpractice.features.support.actor.domain;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.actor.IGreetingGetterActor;

public class GreetingGetterActor implements IGreetingGetterActor {

    private final MoodCenter moodCenter;

    public GreetingGetterActor(MoodCenter moodCenter) {
        this.moodCenter = moodCenter;
    }

    @Override
    public String getGreeting() {
        return moodCenter.getGreeting();
    }
}
