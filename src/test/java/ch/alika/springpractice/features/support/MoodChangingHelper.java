package ch.alika.springpractice.features.support;

import ch.alika.springpractice.domain.IMoodCenter;

public class MoodChangingHelper {
    private final IMoodCenter moodController;

    public MoodChangingHelper(IMoodCenter moodController) {
        this.moodController = moodController;
    }

    public IMoodCenter getMoodController() {
        return moodController;
    }
}
