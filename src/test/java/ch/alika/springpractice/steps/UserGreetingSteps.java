package ch.alika.springpractice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserGreetingSteps {

    @Given("a new user")
    public void a_new_user() {
    }

    @When("the user starts using the application")
    public void user_starts_using_application() {

    }

    @Then("the user should be greeted")
    public void user_should_be_greeted() {
        assertThat("Hello!", not(emptyOrNullString()));
    }
}
