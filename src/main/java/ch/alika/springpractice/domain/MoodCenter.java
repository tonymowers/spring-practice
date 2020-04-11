package ch.alika.springpractice.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MoodCenter {
    private static final IMoodStrategy NULL_STRATEGY = new NullMoodStrategy();

    private IMoodStrategy defaultStrategy;
    private IMoodStrategy currentStrategy;
    private List<IMoodStrategy> moodStrategies;

    public MoodCenter(List<IMoodStrategy> strategies) {
        this.moodStrategies = Optional.ofNullable(strategies).orElse(Collections.emptyList());
        defaultStrategy = moodStrategies.isEmpty() ? NULL_STRATEGY : moodStrategies.get(0);
        currentStrategy = defaultStrategy;
    }

    public MoodCenter() {
        this(Collections.emptyList());
    }

    public List<Mood> getAvailableMoods() {
        return moodStrategies.stream().map(IMoodStrategy::getMood).collect(Collectors.toList());
    }

    public Mood getDefaultMood() {
        return defaultStrategy.getMood();
    }

    public void setDefaultMoodById(String moodId) {
        defaultStrategy = getStrategyById(moodId);
    }

    public Mood getCurrentMood() {
        return Optional.ofNullable(currentStrategy).orElse(defaultStrategy).getMood();
    }

    public void setCurrentMoodById(String id) {
        this.currentStrategy = getStrategyById(id);
    }

    public void setCurrentMoodToDefaultMood() {
        this.currentStrategy = defaultStrategy;
    }

    public String getGreeting() {
        return currentStrategy.getGreeting();
    }

    private IMoodStrategy getStrategyById(String id) {
        Optional<IMoodStrategy> mood = moodStrategies.stream().filter(testIfStrategyHasMoodId(id)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with id = %s",id)));
    }

    private static Predicate<IMoodStrategy> testIfStrategyHasMoodId(String id) {
        return (moodStrategy) -> moodStrategy.getMood().getId().equals(id);
    }

    private static class NullMoodStrategy implements IMoodStrategy {

        @Override
        public Mood getMood() {
            return Mood.NULL_MOOD;
        }

        @Override
        public String getGreeting() {
            return "Howdy!";
        }
    }
}
