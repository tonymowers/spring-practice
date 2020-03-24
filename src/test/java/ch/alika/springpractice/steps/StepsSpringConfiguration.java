package ch.alika.springpractice.steps;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.support.MoodChangingHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Slf4j
@Configuration
public class StepsSpringConfiguration {

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public MoodChangingHelper shopperHelper() {
        log.debug("Instantiating MoodHelper");
        return new MoodChangingHelper(new MoodCenter());
    }
}
