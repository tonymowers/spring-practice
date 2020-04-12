package ch.alika.springpractice.features.support.domain;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.IMoodChangingActor;

import java.util.List;

public class MoodChangingActor implements IMoodChangingActor {

    private final MoodCenter moodCenter;

    public MoodChangingActor(MoodCenter moodCenter) {
        this.moodCenter = moodCenter;
    }

    @Override
    public List<Mood> getAvailableMoods() {
        return moodCenter.getAvailableMoods();
    }

    @Override
    public Mood getDefaultMood() {
        return moodCenter.getDefaultMood();
    }

    @Override
    public void setDefaultMood(Mood mood) {
        moodCenter.setDefaultMoodById(mood.getId());
    }

    @Override
    public Mood getCurrentMood() {
        return moodCenter.getCurrentMood();
    }

    @Override
    public void setCurrentMood(Mood mood) {
        moodCenter.setCurrentMoodById(mood.getId());
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        moodCenter.setCurrentMoodToDefaultMood();
    }

}
