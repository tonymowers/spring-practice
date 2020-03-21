package ch.alika.springpractice.steps;

import ch.alika.springpractice.domain.IMoodController;
import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.ObjectNotFoundException;
import ch.alika.springpractice.support.MoodChangingHelper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodChangingSteps {
    IMoodController moodController;

    public MoodChangingSteps(MoodChangingHelper helper) {
        moodController = helper.getMoodController();
    }

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return new Mood(Integer.parseInt(entry.get("id")), entry.get("name"));
    }

    @Given("the following possible moods:")
    public void theFollowingPossibleMoods(List<Mood> moods) {
        moodController.setPossibleMoods(moods);
    }

    @And("{string} is the default mood")
    public void isTheDefaultMood(String moodName) {
        moodController.setDefaultMoodById(getMoodByName(moodName).getId());
    }

    @Given("nothing is done about the mood")
    public void iHaveDoneNothingAboutMyMood() {
    }

    @Then("the mood should be {string}")
    public void theMoodShouldBe(String moodName) {
        assertThat(moodController.getCurrentMood().getName(),is(moodName));
    }

    @Given("the {string} mood is chosen")
    public void theMoodIsChosen(String moodName) {
        moodController.setCurrentMoodById(getMoodByName(moodName).getId());
    }

    @When("the default mood is chosen")
    public void theDefaulMoodIsChosen() {
        moodController.setCurrentMoodToDefaultMood();
    }

    public Mood getMoodByName(String name) {
        Optional<Mood> mood = moodController.getPossibleMoods().stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new ObjectNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }

}
