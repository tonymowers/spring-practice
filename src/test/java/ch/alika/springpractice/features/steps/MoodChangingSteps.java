package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.screenplay.Actor;
import ch.alika.springpractice.features.support.actor.IMoodChanger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static ch.alika.springpractice.domain.Mood.NULL_MOOD;
import static ch.alika.springpractice.features.support.performables.MoodQuestions.*;
import static ch.alika.springpractice.features.support.performables.MoodTasks.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoodChangingSteps {
    private final Actor<IMoodChanger> actor;
    private boolean exceptionExpected = false;

    public MoodChangingSteps(Actor<IMoodChanger> actor) {
        this.actor = actor;
    }

    @When("{mood_name} is the default mood")
    public void choose_default_mood(Mood mood) {
        actor.attemptsTo(SetDefaultMoodTo(mood));
    }

    @Given("nothing is done about the mood")
    public void nothing_done_about_mood() {
    }

    @Given("the {mood_name} mood is chosen")
    public void choose_mood(Mood mood) {
        actor.wasAbleTo(SetCurrentMoodTo(mood));
    }

    @Then("the mood should be {mood_name}")
    public void should_have_mood(Mood mood) {
        assertThat(actor.shouldSee(CurrentMood()),is(mood));
    }

    @Then("the default mood should be {mood_name}")
    public void should_have_default_mood(Mood mood) {
        assertThat(actor.shouldSee(DefaultMood()),is(mood));
    }

    @Then("the mood should be unknown")
    public void should_have_unknown_mood() {
        assertThat(actor.shouldSee(CurrentMood()),is(NULL_MOOD));
    }

    @Then("the default mood should be unknown")
    public void should_have_unknown_default_mood() {
        assertThat(actor.shouldSee(CurrentMood()),is(NULL_MOOD));
    }

    @When("the default mood is chosen")
    public void choose_default_mood() {
        actor.attemptsTo(SetMoodToDefaultMood());
    }

    @Then("a MoodNotFoundException should be thrown")
    public void should_have_exception_thrown() {
        exceptionExpected = true;
    }

    @When("an unknown mood is chosen")
    public void choose_unknown_mood() {
        if (exceptionExpected)
            assertThrows(MoodNotFoundException.class, () -> actor.attemptsTo(SetCurrentMoodTo(NULL_MOOD)));
    }

}
