package ch.alika.springpractice.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static ch.alika.springpractice.domain.Mood.NULL_MOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoodCenterTests {
    private static final Mood HAPPY = new Mood("happy", "happy");
    private static final Mood SAD = new Mood("sad", "sad");
    public static final String HOWDY_GREETING = "Howdy!";
    public static final String GO_AWAY_GREETING = "Go Aways :-(";
    private IMoodCenter moodCenter;

    @BeforeEach
    public void setUp() {
        moodCenter = new MoodCenter(getFakeStrategies());
        moodCenter.setDefaultMoodById(HAPPY.getId());
    }

    private List<IMoodStrategy> getFakeStrategies() {
        return Arrays.asList(
                new FakeMoodStrategy(HAPPY, HOWDY_GREETING),
                new FakeMoodStrategy(SAD, GO_AWAY_GREETING)
        );
    }


    @Test
    public void whereGetDefaultMood() {
        assertThat(moodCenter.getDefaultMood(),is(HAPPY));
    }

    @Test
    public void whereGetPossibleMoods() {
        List<Mood> moods = moodCenter.getAvailableMoods();

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
        return moodCenter.getAvailableMoods().stream().filter(m -> m.getName().equals(moodName)).findFirst();
    }

    @Test
    public void whereSetCurrentMood() {
        assertThat(moodCenter.getCurrentMood(),is(not(SAD)));
        moodCenter.setCurrentMoodById(SAD.getId());
        assertThat(moodCenter.getCurrentMood(),is(SAD));
    }

    @Test
    public void whereSetCurrentMoodToDefault() {
        moodCenter.setCurrentMoodById(SAD.getId());
        assertThat(moodCenter.getCurrentMood(),is(not(moodCenter.getDefaultMood())));
        moodCenter.setCurrentMoodToDefaultMood();
        assertThat(moodCenter.getCurrentMood(),is(moodCenter.getDefaultMood()));
    }

    @Test
    public void whereGetCurrentMoodWhenCurrentMoodNotSet() {
        assertThat(moodCenter.getCurrentMood(),is(moodCenter.getDefaultMood()));
    }

    @Test
    public void whereSetDefaultMood() {
        assertThat(moodCenter.getDefaultMood(),is(not(SAD)));
        moodCenter.setDefaultMoodById(SAD.getId());
        assertThat(moodCenter.getDefaultMood(),is(SAD));
    }

    @Test
    public void whereGetDefaultMoodWhenNoDefaultSet() {
        assertThat(moodCenter.getDefaultMood(),is(HAPPY));
    }

    @Test
    public void whereGetDefaultMoodWhenNoMoods() {
        moodCenter = new MoodCenter();
        assertThat(moodCenter.getDefaultMood(),is(NULL_MOOD));
    }

    @Test
    public void whereGetCurrentMoodWhenNoMoods() {
        moodCenter = new MoodCenter();
        assertThat(moodCenter.getCurrentMood(),is(NULL_MOOD));
    }

    @Test
    public void whereSetCurrentMoodToUnknownMood() {
        assertThrows(MoodNotFoundException.class, () -> moodCenter.setCurrentMoodById(NULL_MOOD.getId()));
    }

    @Test
    public void whereNullMoodGreetingRetrieved() {
        moodCenter = new MoodCenter();
        assertThat(moodCenter.getCurrentMood(),is(NULL_MOOD));
        assertThat(moodCenter.getGreeting(),is(HOWDY_GREETING));
    }

    @Test
    public void whereGreetedByCurrentMood() {
        moodCenter.setCurrentMoodById(HAPPY.getId());
        assertThat(moodCenter.getGreeting(),is(HOWDY_GREETING));

        moodCenter.setCurrentMoodById(SAD.getId());
        assertThat(moodCenter.getGreeting(),is(GO_AWAY_GREETING));
    }


    private static class FakeMoodStrategy implements IMoodStrategy {

        private final Mood mood;
        private final String greeting;

        public FakeMoodStrategy(Mood mood, String greeting) {
            this.mood = mood;
            this.greeting = greeting;
        }

        @Override
        public Mood getMood() {
            return mood;
        }

        @Override
        public IGreetingSupplier getGreetingSupplier() {
            return () -> greeting;
        }
    }
}