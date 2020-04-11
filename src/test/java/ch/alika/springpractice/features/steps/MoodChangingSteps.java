package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.IMoodChangingActor;
import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;
import java.util.Optional;

import static ch.alika.springpractice.domain.Mood.NULL_MOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoodChangingSteps {
    private final IMoodChangingActor actor;
    private boolean exceptionExpected = false;

    public MoodChangingSteps(IMoodChangingActor moodChangingActor) {
        this.actor = moodChangingActor;
    }

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return new Mood(entry.get("id"), entry.get("name"));
    }

    @ParameterType(value = "\"(.*)\"", name = "mood_name")
    public Mood mood(String moodName) {
        return getMoodByName(moodName);
    }

    @When("{mood_name} is the default mood")
    public void choose_default_mood(Mood mood) {
        actor.setDefaultMood(mood);
    }

    @Given("nothing is done about the mood")
    public void nothing_done_about_mood() {
    }

    @Given("the {mood_name} mood is chosen")
    public void choose_mood(Mood mood) {
        actor.setCurrentMood(mood);
    }

    @Then("the mood should be {mood_name}")
    public void should_have_mood(Mood mood) {
        assertThat(actor.getCurrentMood(),is(mood));
    }

    @Then("the default mood should be {mood_name}")
    public void should_have_default_mood(Mood mood) {
        assertThat(actor.getDefaultMood(),is(mood));
    }

    @Then("the mood should be unknown")
    public void should_have_unknown_mood() {
        assertThat(actor.getCurrentMood(),is(NULL_MOOD));
    }

    @Then("the default mood should be unknown")
    public void should_have_unknown_default_mood() {
        assertThat(actor.getCurrentMood(),is(NULL_MOOD));
    }

    @When("the default mood is chosen")
    public void choose_default_mood() {
        actor.setCurrentMoodToDefaultMood();
    }

    @Then("a MoodNotFoundException should be thrown")
    public void should_have_exception_thrown() {
        exceptionExpected = true;
    }

    @When("an unknown mood is chosen")
    public void choose_unknown_mood() {
        if (exceptionExpected)
            assertThrows(MoodNotFoundException.class, () -> actor.setCurrentMood(NULL_MOOD));
    }

    private Mood getMoodByName(String name) {
        Optional<Mood> mood = actor.getAvailableMoods().stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }


}
