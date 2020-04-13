package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.features.support.actor.IGreetingGetter;
import ch.alika.springpractice.features.support.screenplay.Actor;
import io.cucumber.java8.En;

import static ch.alika.springpractice.features.support.performables.GreetingQuestions.Greeting;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SuppressWarnings("unused")
public class MoodBasedGreetingSteps implements En {

    private final Actor<IGreetingGetter> actor;

    public MoodBasedGreetingSteps(Actor<IGreetingGetter> actor) {
        this.actor = actor;

        Then("the greeting should be {string}",
                (String expectedGreeting) -> assertThat(actor.shouldSee(Greeting()),equalTo(expectedGreeting))
        );

    }

}
