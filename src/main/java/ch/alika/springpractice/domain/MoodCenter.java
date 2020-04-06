package ch.alika.springpractice.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoodCenter implements IMoodCenter {
    private static final IMoodStrategy NULL_MOOD_STRATEGY = new NullMoodStrategy();

    private IMoodStrategy defaultStrategy;
    private IMoodStrategy currentStrategy;
    private List<IMoodStrategy> strategies;

    public MoodCenter() {
        this(Collections.emptyList());
    }

    public MoodCenter(List<IMoodStrategy> strategies) {
        this.strategies = strategies;
        if (strategies.isEmpty()) {
            defaultStrategy = NULL_MOOD_STRATEGY;
        } else {
            defaultStrategy = strategies.get(0);
        }
        currentStrategy = defaultStrategy;
    }

    @Override
    public List<Mood> getAvailableMoods() {
        return strategies.stream().map(IMoodStrategy::getMood).collect(Collectors.toList());
    }

    @Override
    public Mood getDefaultMood() {
        return defaultStrategy.getMood();
    }

    @Override
    public void setDefaultMoodById(String moodId) {
        defaultStrategy = getMoodStrategyById(moodId);
    }

    @Override
    public Mood getCurrentMood() {
        return currentStrategy.getMood();
    }

    @Override
    public void setCurrentMoodById(String id) {
        this.currentStrategy = getMoodStrategyById(id);
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        this.currentStrategy = defaultStrategy;
    }

    private IMoodStrategy getMoodStrategyById(String id) {
        Optional<IMoodStrategy> mood = strategies.stream().filter(m -> m.getMood().getId().equals(id)).findFirst();
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
