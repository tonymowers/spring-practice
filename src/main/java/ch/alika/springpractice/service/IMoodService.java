package ch.alika.springpractice.service;

import ch.alika.springpractice.domain.Mood;

public interface IMoodService {

    MoodOverview getMoodOverview();

    Mood getCurrentMood();

    void setCurrentMoodById(String moodId);
}
