package ch.alika.springpractice.features.support.domain;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.IMoodCenterActor;

import java.util.List;

public class MoodCenterActor implements IMoodCenterActor {

    private final MoodCenter moodCenter;

    public MoodCenterActor(MoodCenter moodCenter) {
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
    public void setDefaultMoodById(String moodId) {
        moodCenter.setDefaultMoodById(moodId);
    }

    @Override
    public Mood getCurrentMood() {
        return moodCenter.getCurrentMood();
    }

    @Override
    public void setCurrentMoodById(String id) {
        moodCenter.setCurrentMoodById(id);
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        moodCenter.setCurrentMoodToDefaultMood();
    }

}
