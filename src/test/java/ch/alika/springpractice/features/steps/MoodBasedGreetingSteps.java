package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.actor.IGreetingGetterActor;
import io.cucumber.java8.En;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@SuppressWarnings("unused")
public class MoodBasedGreetingSteps implements En {

    public MoodBasedGreetingSteps(IGreetingGetterActor actor) {

        Then("the greeting should be {string}",
                (String expectedGreeting) -> assertThat(actor.getGreeting(),equalTo(expectedGreeting))
        );

    }

}
