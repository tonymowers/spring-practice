package ch.alika.springpractice.features.support.performables;

import ch.alika.springpractice.domain.Mood;
import ch.alika.screenplay.IActorQuestion;
import ch.alika.springpractice.features.support.actor.IMoodChanger;

import java.util.List;

public class MoodQuestions {

    public static IActorQuestion<IMoodChanger, Mood> CurrentMood() {
        return IMoodChanger::getCurrentMood;
    }

    public static IActorQuestion<IMoodChanger, Mood> DefaultMood() {
        return IMoodChanger::getDefaultMood;
    }

    public static IActorQuestion<IMoodChanger, List<Mood>> AvailableMoods() {
        return IMoodChanger::getAvailableMoods;
    }
}
