package ch.alika.springpractice.features.support;

import ch.alika.springpractice.domain.Mood;

import java.util.List;

public interface IMoodChangingActor {

    List<Mood> getAvailableMoods();

    Mood getDefaultMood();

    void setDefaultMoodById(String moodId);

    Mood getCurrentMood();

    void setCurrentMoodById(String id);

    void setCurrentMoodToDefaultMood();
}
