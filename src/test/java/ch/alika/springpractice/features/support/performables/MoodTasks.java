package ch.alika.springpractice.features.support.performables;

import ch.alika.springpractice.domain.Mood;
import ch.alika.screenplay.IActorTask;
import ch.alika.springpractice.features.support.actor.IMoodChanger;

public class MoodTasks {

    public static IActorTask<IMoodChanger> SetDefaultMoodTo(Mood mood) {
        return (actor) -> actor.setDefaultMood(mood);
    }

    public static IActorTask<IMoodChanger> SetCurrentMoodTo(Mood mood) {
        return (actor) -> actor.setCurrentMood(mood);
    }

    public static IActorTask<IMoodChanger> SetMoodToDefaultMood() {
        return IMoodChanger::setCurrentMoodToDefaultMood;
    }

}
