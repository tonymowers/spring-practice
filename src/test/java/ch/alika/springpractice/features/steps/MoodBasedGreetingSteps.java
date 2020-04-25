package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.actor.IGreetingGetterActor;
import io.cucumber.java.en.Then;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unused")
public class MoodBasedGreetingSteps  {

    private final IGreetingGetterActor actor;

    public MoodBasedGreetingSteps(IGreetingGetterActor actor) {
        this.actor = actor;
    }

    @Then("the greeting should be {string}")
    public void should_be_greeted_by(String expectedGreeting) {
        assertThat(actor.getGreeting(),equalTo(expectedGreeting));
    }

}
