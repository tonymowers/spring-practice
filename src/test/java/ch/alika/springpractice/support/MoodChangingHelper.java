package ch.alika.springpractice.support;

import ch.alika.springpractice.domain.IMoodController;

public class MoodChangingHelper {
    private final IMoodController moodController;

    public MoodChangingHelper(IMoodController moodController) {
        this.moodController = moodController;
    }

    public IMoodController getMoodController() {
        return moodController;
    }
}
