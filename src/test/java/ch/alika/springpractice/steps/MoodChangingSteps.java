package ch.alika.springpractice.steps;

import ch.alika.springpractice.domain.IMoodCenter;
import ch.alika.springpractice.domain.Mood;
import ch.alika.springpractice.domain.Moods;
import ch.alika.springpractice.domain.ObjectNotFoundException;
import ch.alika.springpractice.support.MoodChangingHelper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodChangingSteps {
    IMoodCenter moodController;

    public MoodChangingSteps(MoodChangingHelper helper) {
        moodController = helper.getMoodController();
    }

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return Moods.createSimpleMood(Integer.parseInt(entry.get("id")), entry.get("name"));
    }

    @ParameterType("\"(.*)\"")
    public Mood mood(String moodName) {
        return getMoodByName(moodName);
    }

    @Given("the following possible moods:")
    public void theFollowingPossibleMoods(List<Mood> moods) {
        moodController.setAvailableMoods(moods);
    }

    @When("{mood} is the default mood")
    public void isTheDefaultMood(Mood mood) {
        moodController.setDefaultMoodById(mood.getId());
    }

    @Given("nothing is done about the mood")
    public void iHaveDoneNothingAboutMyMood() {
    }

    @Then("the mood should be {mood}")
    public void theMoodShouldBe(Mood mood) {
        assertThat(moodController.getCurrentMood(),is(mood));
    }

    @Given("the {mood} mood is chosen")
    public void theMoodIsChosen(Mood mood) {
        moodController.setCurrentMoodById(mood.getId());
    }

    @When("the default mood is chosen")
    public void theDefaulMoodIsChosen() {
        moodController.setCurrentMoodToDefaultMood();
    }


    private Mood getMoodByName(String name) {
        Optional<Mood> mood = moodController.getAvailableMoods().stream().filter(m -> m.getName().equals(name)).findFirst();
        return mood.orElseThrow(() -> new ObjectNotFoundException(String.format("unable to find Mood with name = %s",name)));
    }


}
