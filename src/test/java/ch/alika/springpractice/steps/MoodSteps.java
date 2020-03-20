package ch.alika.springpractice.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Value;

import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MoodSteps {
    MoodRepository moodRepository  = new MoodRepository();

    @DataTableType
    public Mood moodEntry(Map<String, String> entry) {
        return new Mood(Integer.parseInt(entry.get("id")), entry.get("name"));
    }

    @Given("the following possible moods:")
    public void theFollowingPossibleMoods(List<Mood> moods) {
        moodRepository.putMoods(moods);
    }

    @And("{string} is the default mood")
    public void isTheDefaultMood(String moodName) {
        moodRepository.setDefaultMoodById(findMoodMoodByName(moodName).getId());
    }

    @Given("I have done nothing about my mood")
    public void iHaveDoneNothingAboutMyMood() {
    }

    @Then("I should be in a {string} mood")
    public void iShouldBeInAMood(String moodName) {
        assertThat(moodRepository.getCurrentMood().getName(),is(moodName));
    }

    @Given("I have chosen a {string} mood")
    public void iHaveChosenAMood(String moodName) {
        moodRepository.setCurrentMoodById(moodRepository.getMoodByName(moodName).getId());
    }

    @When("I have chosen my default mood")
    public void iHaveChosenMyDefaultMood() {
        moodRepository.setCurrentMoodToDefaultMood();
    }

    @Value
    private static class Mood {
        int id;
        String name;
    }

    private static class MoodRepository {
        private Integer defaultMoodId;
        private Integer currentMoodId;
        private List<Mood> moods = Collections.emptyList();

        public void putMoods(List<Mood> moods) {
            this.moods = moods;
        }

        public Mood getMoodByName(String name) {
            Optional<Mood> mood = moods.stream().filter(m -> m.getName().equals(name)).findFirst();
            mood.orElseThrow(() -> new ObjectNotFoundException(String.format("unable to find Mood with id = %s",name)));
            return mood.get();
        }

        public Mood getMoodById(int id) {
            Optional<Mood> mood = moods.stream().filter(m -> m.getId() == id).findFirst();
            mood.orElseThrow(() -> new ObjectNotFoundException(String.format("unable to find Mood with id = %d",id)));
            return mood.get();
        }

        public Mood getDefaultMood() {
            if (moods.isEmpty())
                throw new ObjectNotFoundException("No default mood found because no moods have been defined");

            return getDefaultModeId().map(this::getMoodById).orElse(moods.get(0));
        }

        public void setDefaultMoodById(int moodId) {
            defaultMoodId = getMoodById(moodId).getId();
        }

        public Mood getCurrentMood() {
            return getCurrentMoodId().map(this::getMoodById).orElse(getDefaultMood());
        }

        public void setCurrentMoodById(int id) {
            this.currentMoodId = id;
        }

        private Optional<Integer> getCurrentMoodId() {
            return Optional.ofNullable(currentMoodId);
        }

        private Optional<Integer> getDefaultModeId() {
            return Optional.ofNullable(defaultMoodId);
        }

        public void setCurrentMoodToDefaultMood() {
            this.currentMoodId = defaultMoodId;
        }
    }

    private Mood findMoodMoodByName(String moodName) {
        return moodRepository.getMoodById(moodRepository.getMoodByName(moodName).getId());
    }

    private static class ObjectNotFoundException extends RuntimeException {
        public ObjectNotFoundException(String msg) {
            super(msg);
        }
    }
}
