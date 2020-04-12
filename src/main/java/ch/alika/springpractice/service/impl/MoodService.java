package ch.alika.springpractice.service.impl;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.service.IMoodService;
import ch.alika.springpractice.service.MoodOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodService implements IMoodService {

    private final MoodCenter moodCenter;

    @Autowired
    public MoodService(MoodCenter moodCenter) {
        this.moodCenter = moodCenter;
    }

    @Override
    public MoodOverview getMoodOverview() {
        return new MoodOverview(
                moodCenter.getCurrentMood(),
                moodCenter.getDefaultMood(),
                moodCenter.getAvailableMoods()
        );
    }

    @Override
    public Mood getCurrentMood() {
        return moodCenter.getCurrentMood();
    }

    @Override
    public void setCurrentMoodById(String moodId) {
        moodCenter.setCurrentMoodById(moodId);
    }
}
