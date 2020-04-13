package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.features.support.actor.IMoodChanger;
import ch.alika.springpractice.features.support.screenplay.Actor;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;

import java.util.Map;
import java.util.Optional;

import static ch.alika.springpractice.features.support.performables.MoodQuestions.AvailableMoods;

public class ParameterTypes {
    private final Actor<IMoodChanger> actor;

    public ParameterTypes(Actor<IMoodChanger> actor) {
        this.actor = actor;
    }

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return new Mood(entry.get("id"), entry.get("name"));
    }

    @ParameterType(value = "\"(.*)\"", name = "mood_name")
    public Mood mood(String moodName) {
        return getMoodByName(moodName);
    }

    private Mood getMoodByName(String name) {
        Optional<Mood> mood = actor.shouldSee(AvailableMoods()).stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }
}
