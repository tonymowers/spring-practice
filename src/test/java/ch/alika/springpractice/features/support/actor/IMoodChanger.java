package ch.alika.springpractice.features.support.actor;

import ch.alika.springpractice.domain.Mood;

import java.util.List;

public interface IMoodChanger extends IActor {

    List<Mood> getAvailableMoods();

    Mood getDefaultMood();

    void setDefaultMood(Mood mood);

    Mood getCurrentMood();

    void setCurrentMood(Mood mood);

    void setCurrentMoodToDefaultMood();
}
