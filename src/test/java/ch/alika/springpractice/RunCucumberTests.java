package ch.alika.springpractice;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"not @pending"},
        plugin = {"pretty", "de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        features = "classpath:features",
        strict = true,
        snippets = CAMELCASE)
public class RunCucumberTests {

}