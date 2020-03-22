package ch.alika.springpractice.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MoodCenter implements IMoodCenter {
    private Mood defaultMood = Mood.NULL_MOOD;
    private Mood currentMood;
    private List<Mood> moods = Collections.emptyList();

    @Override
    public void setAvailableMoods(List<Mood> moods) {
        this.moods = moods;
        if (moods.isEmpty()) {
            defaultMood = Mood.NULL_MOOD;
        } else {
            defaultMood = moods.get(0);
        }
    }

    @Override
    public List<Mood> getAvailableMoods() {
        return new ArrayList<>(moods);
    }

    @Override
    public Mood getMoodById(int id) {
        Optional<Mood> mood = moods.stream().filter(m -> m.getId() == id).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with id = %d",id)));
    }

    @Override
    public Mood getDefaultMood() {
        return defaultMood;
    }

    @Override
    public void setDefaultMoodById(int moodId) {
        defaultMood = getMoodById(moodId);
    }

    @Override
    public Mood getCurrentMood() {
        return Optional.ofNullable(currentMood).orElse(defaultMood);
    }

    @Override
    public void setCurrentMoodById(int id) {
        this.currentMood = getMoodById(id);
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        this.currentMood = defaultMood;
    }

}
