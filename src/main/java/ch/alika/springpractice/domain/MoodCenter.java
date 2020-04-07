package ch.alika.springpractice.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoodCenter implements IMoodCenter {
    private static final IMoodStrategy NULL_STRATEGY = new NullMoodStrategy();

    private IMoodStrategy defaultMood;
    private IMoodStrategy currentMood;
    private List<IMoodStrategy> moods;

    public MoodCenter(List<IMoodStrategy> strategies) {
        this.moods = strategies;
        if (moods.isEmpty()) {
            defaultMood = NULL_STRATEGY;
        } else {
            defaultMood = moods.get(0);
        }
        currentMood = defaultMood;
    }

    public MoodCenter() {
        this(Collections.emptyList());
    }

    @Override
    public List<Mood> getAvailableMoods() {
        return moods.stream().map(IMoodStrategy::getMood).collect(Collectors.toList());
    }

    @Override
    public Mood getDefaultMood() {
        return defaultMood.getMood();
    }

    @Override
    public void setDefaultMoodById(String moodId) {
        defaultMood = getMoodById(moodId);
    }

    @Override
    public Mood getCurrentMood() {
        return Optional.ofNullable(currentMood).orElse(defaultMood).getMood();
    }

    @Override
    public void setCurrentMoodById(String id) {
        this.currentMood = getMoodById(id);
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        this.currentMood = defaultMood;
    }

    private IMoodStrategy getMoodById(String id) {
        Optional<IMoodStrategy> mood = moods.stream().filter(m -> m.getMood().getId().equals(id)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with id = %s",id)));
    }

    @Override
    public String getGreeting() {
        return currentMood.getGreetingSupplier().getGreeting();
    }

    private static class NullMoodStrategy implements IMoodStrategy {

        @Override
        public Mood getMood() {
            return Mood.NULL_MOOD;
        }

        @Override
        public IGreetingSupplier getGreetingSupplier() {
            return () -> "Howdy!";
        }
    }
}
