package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.features.support.actor.IMoodChangerActor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ch.alika.springpractice.domain.Mood.NULL_MOOD;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoodChangingSteps {
    private final IMoodChangerActor actor;
    private boolean exceptionExpected = false;

    public MoodChangingSteps(IMoodChangerActor moodChanger) {
        this.actor = moodChanger;
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

}
