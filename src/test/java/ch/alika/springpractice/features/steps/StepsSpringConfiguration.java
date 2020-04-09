package ch.alika.springpractice.features.steps;

import ch.alika.springpractice.domain.IMoodCenter;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.moodimpl.HappyStrategy;
import ch.alika.springpractice.moodimpl.SadStrategy;
import ch.alika.springpractice.features.support.MoodChangingHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Slf4j
@Configuration
public class StepsSpringConfiguration {

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public MoodChangingHelper shopperHelper(IMoodCenter moodCenter) {
        log.debug("Instantiating MoodHelper");
        return new MoodChangingHelper(moodCenter);
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public IMoodCenter moodCenter() {
        return new MoodCenter(Arrays.asList(
                new HappyStrategy(),
                new SadStrategy()
        ));
    }
}
