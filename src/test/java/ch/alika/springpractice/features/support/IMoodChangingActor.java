package ch.alika.springpractice.features.support;

import ch.alika.springpractice.domain.Mood;

import java.util.List;

public interface IMoodChangingActor extends IActor {

    List<Mood> getAvailableMoods();

    Mood getDefaultMood();

    void setDefaultMood(Mood mood);

    Mood getCurrentMood();

    void setCurrentMood(Mood mood);

    void setCurrentMoodToDefaultMood();
}
