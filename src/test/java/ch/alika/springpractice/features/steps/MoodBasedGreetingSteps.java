package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.IGreetedActor;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodBasedGreetingSteps {

    private final IGreetedActor actor;

    public MoodBasedGreetingSteps(IGreetedActor greetedActor) {
        this.actor = greetedActor;
    }

    @Then("the greeting should be {string}")
    public void should_be_greeted_by(String greeting) {
        assertThat(actor.getGreeting(),is(greeting));
    }
}
