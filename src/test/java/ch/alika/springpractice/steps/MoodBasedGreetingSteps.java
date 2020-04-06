package ch.alika.springpractice.steps;

import ch.alika.springpractice.domain.IGreetingSupplier;
import ch.alika.springpractice.support.MoodChangingHelper;
import io.cucumber.java.en.Then;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodBasedGreetingSteps {

    private final IGreetingSupplier greetingSupplier;

    public MoodBasedGreetingSteps(MoodChangingHelper helper) {
        this.greetingSupplier = helper.getMoodController();
    }

    @Then("the greeting should be {string}")
    public void theGreetingShouldBe(String greeting) {
        assertThat(greetingSupplier.getGreeting(),is(greeting));
    }
}
