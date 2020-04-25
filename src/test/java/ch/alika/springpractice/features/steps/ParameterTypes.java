package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.features.support.actor.IMoodChangerActor;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.util.Map;
import java.util.Optional;

public class ParameterTypes {
    private final IMoodChangerActor actor;

    public ParameterTypes(IMoodChangerActor moodChanger) {
        this.actor = moodChanger;
    }

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return new Mood(entry.get("id"), entry.get("name"));
    }

    @ParameterType(value = "\"(.*)\"", name = "mood_name")
    public Mood mood_name(String moodName) {
        return getMoodByName(moodName);
    }

    private Mood getMoodByName(String name) {
        Optional<Mood> mood = actor.getAvailableMoods().stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }
}
