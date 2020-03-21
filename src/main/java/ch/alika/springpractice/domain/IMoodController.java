package ch.alika.springpractice.domain;

import java.util.List;

public interface IMoodController {
    void setPossibleMoods(List<Mood> moods);

    List<Mood> getPossibleMoods();

    Mood getMoodById(int id);

    Mood getDefaultMood();

    void setDefaultMoodById(int moodId);

    Mood getCurrentMood();

    void setCurrentMoodById(int id);

    void setCurrentMoodToDefaultMood();
}
