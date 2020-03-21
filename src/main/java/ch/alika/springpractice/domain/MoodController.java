package ch.alika.springpractice.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MoodController implements IMoodController {
    private Integer defaultMoodId;
    private Integer currentMoodId;
    private List<Mood> moods = Collections.emptyList();

    @Override
    public void setPossibleMoods(List<Mood> moods) {
        this.moods = moods;
    }

    @Override
    public Mood getMoodById(int id) {
        Optional<Mood> mood = moods.stream().filter(m -> m.getId() == id).findFirst();
        return mood.orElseThrow(() -> new ObjectNotFoundException(String.format("unable to find Mood with id = %d",id)));
    }

    @Override
    public Mood getDefaultMood() {
        if (moods.isEmpty())
            throw new ObjectNotFoundException("No default mood found because no moods have been defined");

        return getDefaultModeId().map(this::getMoodById).orElse(moods.get(0));
    }

    @Override
    public void setDefaultMoodById(int moodId) {
        defaultMoodId = getMoodById(moodId).getId();
    }

    @Override
    public Mood getCurrentMood() {
        return getCurrentMoodId().map(this::getMoodById).orElse(getDefaultMood());
    }

    @Override
    public void setCurrentMoodById(int id) {
        this.currentMoodId = id;
    }

    @Override
    public void setCurrentMoodToDefaultMood() {
        this.currentMoodId = defaultMoodId;
    }

    @Override
    public List<Mood> getPossibleMoods() {
        return new ArrayList<>(moods);
    }

    private Optional<Integer> getCurrentMoodId() {
        return Optional.ofNullable(currentMoodId);
    }

    private Optional<Integer> getDefaultModeId() {
        return Optional.ofNullable(defaultMoodId);
    }

}
