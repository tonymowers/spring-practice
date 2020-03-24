package ch.alika.springpractice.domain;

import java.util.List;

public interface IMoodCenter {

    void setAvailableMoods(List<Mood> moods);

    List<Mood> getAvailableMoods();

    Mood getDefaultMood();

    void setDefaultMoodById(String moodId);

    Mood getCurrentMood();

    void setCurrentMoodById(String id);

    void setCurrentMoodToDefaultMood();
}
