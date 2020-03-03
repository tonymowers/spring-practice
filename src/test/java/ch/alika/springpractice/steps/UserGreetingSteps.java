package ch.alika.springpractice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

@SpringBootTest(classes = StepsSpringConfiguration.class)
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
