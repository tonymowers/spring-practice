package ch.alika.springpractice.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoodCenter implements IMoodCenter {
    private static final IMoodStrategy NULL_STRATEGY = new NullMoodStrategy();

    private IMoodStrategy defaultStrategy;
    private IMoodStrategy currentStrategy;
    private List<IMoodStrategy> moodStrategies;

    public MoodCenter(List<IMoodStrategy> strategies) {
        this.moodStrategies = strategies;
        if (moodStrategies.isEmpty()) {
            defaultStrategy = NULL_STRATEGY;
        } else {
            defaultStrategy = moodStrategies.get(0);
        }
        currentStrategy = defaultStrategy;
    }

    public MoodCenter() {
        this(Collections.emptyList());
    }

    @Override
    public List<Mood> getAvailableMoods() {
        return moodStrategies.stream().map(IMoodStrategy::getMood).collect(Collectors.toList());
    }

    @Override
    public Mood getDefaultMood() {
        return defaultStrategy.getMood();
    }

    @Override
    public void setDefaultMoodById(String moodId) {
        defaultStrategy = getMoodById(moodId);
    }

    @Override
    public Mood getCurrentMood() {
        return Optional.ofNullable(currentStrategy).orElse(defaultStrategy).getMood();
    }

    @Override
    public void setCurrentMoodById(String id) {
        this.currentStrategy = getMoodById(id);
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        this.currentStrategy = defaultStrategy;
    }

    private IMoodStrategy getMoodById(String id) {
        Optional<IMoodStrategy> mood = moodStrategies.stream().filter(m -> m.getMood().getId().equals(id)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with id = %s",id)));
    }

    @Override
    public String getGreeting() {
        return currentStrategy.getGreetingSupplier().getGreeting();
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
