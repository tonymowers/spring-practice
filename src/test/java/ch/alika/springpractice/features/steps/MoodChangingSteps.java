package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.IMoodCenter;
import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.MoodNotFoundException;
import ch.alika.springpractice.features.support.MoodChangingHelper;
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
    private final IMoodCenter moodController;
    private boolean exceptionExpected = false;

    public MoodChangingSteps(MoodChangingHelper helper) {
        moodController = helper.getMoodController();
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
    public void isTheDefaultMood(Mood mood) {
        moodController.setDefaultMoodById(mood.getId());
    }

    @Given("nothing is done about the mood")
    public void iHaveDoneNothingAboutMyMood() {
    }

    @Then("the mood should be {mood_name}")
    public void theMoodShouldBe(Mood mood) {
        assertThat(moodController.getCurrentMood(),is(mood));
    }

    @Then("the default mood should be {mood_name}")
    public void theDefaultMoodShouldBe(Mood mood) {
        assertThat(moodController.getDefaultMood(),is(mood));
    }

    @Then("the mood should be unknown")
    public void theMoodShouldBeUnknown() {
        assertThat(moodController.getCurrentMood(),is(NULL_MOOD));
    }

    @Then("the default mood should be unknown")
    public void theDefaultMoodShouldBeUnknown() {
        assertThat(moodController.getCurrentMood(),is(NULL_MOOD));
    }

    @Given("the {mood_name} mood is chosen")
    public void theMoodIsChosen(Mood mood) {
        moodController.setCurrentMoodById(mood.getId());
    }

    @When("the default mood is chosen")
    public void theDefaultMoodIsChosen() {
        moodController.setCurrentMoodToDefaultMood();
    }

    @Then("a MoodNotFoundException should be thrown")
    public void exceptionShouldBeThrown() {
        exceptionExpected = true;
    }

    @When("an unknown mood is chosen")
    public void doNoMore() {
        if (exceptionExpected)
            assertThrows(MoodNotFoundException.class, () -> moodController.setCurrentMoodById(NULL_MOOD.getId()));
    }

    private Mood getMoodByName(String name) {
        Optional<Mood> mood = moodController.getAvailableMoods().stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new MoodNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }


}
