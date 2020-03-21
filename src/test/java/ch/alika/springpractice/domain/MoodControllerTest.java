package ch.alika.springpractice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoodControllerTest {
    private static final Mood HAPPY = new Mood(0, "happy");
    private static final Mood SAD = new Mood(1, "sad");
    private IMoodController moodController;

    @BeforeEach
    public void setUp() {
        moodController = new MoodController();
        List<Mood> moods = new ArrayList<>(Arrays.asList(
                HAPPY,
                SAD));
        moodController.setPossibleMoods(moods);
        moodController.setDefaultMoodById(HAPPY.getId());
    }


    @Test
    public void whereGetDefaultMood() {
        assertThat(moodController.getDefaultMood(),is(HAPPY));
    }

    @Test
    public void whereGetPossibleMoods() {
        List<Mood> moods = moodController.getPossibleMoods();

        assertThat(moods.size(),is(2));
        assertTrue(moods.contains(SAD));
        assertTrue(moods.contains(HAPPY));
    }

    @Test
    public void whereGetMoodByName() {
        assertTrue(getMoodByName(HAPPY.getName()).isPresent());
    }

    @SuppressWarnings("SameParameterValue")
    private Optional<Mood> getMoodByName(String moodName) {
        return moodController.getPossibleMoods().stream().filter(m -> m.getName().equals(moodName)).findFirst();
    }

    @Test
    public void whereSetCurrentMood() {
        assertThat(moodController.getCurrentMood(),is(not(SAD)));
        moodController.setCurrentMoodById(SAD.getId());
        assertThat(moodController.getCurrentMood(),is(SAD));
    }

    @Test
    public void whereSetCurrentMoodToDefault() {
        moodController.setCurrentMoodById(SAD.getId());
        assertThat(moodController.getCurrentMood(),is(not(moodController.getDefaultMood())));
        moodController.setCurrentMoodToDefaultMood();
        assertThat(moodController.getCurrentMood(),is(moodController.getDefaultMood()));
    }

    @Test
    public void whereGetCurrentMoodWhenCurrentMoodNotSet() {
        assertThat(moodController.getCurrentMood(),is(moodController.getDefaultMood()));
    }

    @Test
    public void whereSetDefaultMood() {
        assertThat(moodController.getDefaultMood(),is(not(SAD)));
        moodController.setDefaultMoodById(SAD.getId());
        assertThat(moodController.getDefaultMood(),is(SAD));
    }

    @Test
    public void whereGetDefaultMoodWhenNoDefaultSet() {
        moodController = new MoodController();
        List<Mood> moods = new ArrayList<>(Arrays.asList(
                HAPPY,
                SAD));
        moodController.setPossibleMoods(moods);
        assertThat(moodController.getDefaultMood(),is(HAPPY));
    }

    @Test
    public void whereGetDefaultMoodWhenNoMoods() {
        moodController = new MoodController();
        assertThrows(ObjectNotFoundException.class, () -> moodController.getDefaultMood());
    }

    @Test
    public void whereGetCurrentMoodWhenNoMoods() {
        moodController = new MoodController();
        assertThrows(ObjectNotFoundException.class, () -> moodController.getDefaultMood());
    }
}