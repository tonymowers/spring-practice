package ch.alika.springpractice.domain;

import java.util.List;

public interface IMoodCenter {

    void setAvailableMoods(List<Mood> moods);

    List<Mood> getAvailableMoods();

    Mood getMoodById(int id);

    Mood getDefaultMood();

    void setDefaultMoodById(int moodId);

    Mood getCurrentMood();

    void setCurrentMoodById(int id);

    void setCurrentMoodToDefaultMood();
}
