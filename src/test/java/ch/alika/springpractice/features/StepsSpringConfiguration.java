package ch.alika.springpractice.features;

import ch.alika.springpractice.features.support.*;
import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.domain.GreetedActor;
import ch.alika.springpractice.features.support.domain.MoodChangingActor;
import ch.alika.springpractice.moodimpl.HappyStrategy;
import ch.alika.springpractice.moodimpl.SadStrategy;
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
    public IMoodChangingActor moodCenterActor(MoodCenter moodCenter) {
        return new MoodChangingActor(moodCenter);
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public IGreetedActor greetedActor(MoodCenter moodCenter) {
        return new GreetedActor(moodCenter);
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public MoodCenter moodCenter() {
        return new MoodCenter(Arrays.asList(
                new HappyStrategy(),
                new SadStrategy()
        ));
    }
}
