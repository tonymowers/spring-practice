package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.IMoodCenter;
import ch.alika.springpractice.features.support.MoodChangingHelper;
import io.cucumber.java.en.Then;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodBasedGreetingSteps {

    private final IMoodCenter moodCenter;

    public MoodBasedGreetingSteps(MoodChangingHelper helper) {
        this.moodCenter = helper.getMoodController();
    }

    @Then("the greeting should be {string}")
    public void theGreetingShouldBe(String greeting) {
        assertThat(moodCenter.getGreeting(),is(greeting));
    }
}
