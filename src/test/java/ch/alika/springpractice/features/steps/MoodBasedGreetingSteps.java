package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.IGreetedActor;
import io.cucumber.java.en.Then;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodBasedGreetingSteps {

    private final IGreetedActor greetedActor;

    public MoodBasedGreetingSteps(IGreetedActor greetedActor) {
        this.greetedActor = greetedActor;
    }

    @Then("the greeting should be {string}")
    public void theGreetingShouldBe(String greeting) {
        assertThat(greetedActor.getGreeting(),is(greeting));
    }
}
