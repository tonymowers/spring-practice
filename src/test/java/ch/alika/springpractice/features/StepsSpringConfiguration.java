package ch.alika.springpractice.features;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.domain.moodimpl.HappyStrategy;
import ch.alika.springpractice.domain.moodimpl.SadStrategy;
import ch.alika.springpractice.features.support.actor.IGreetingGetterActor;
import ch.alika.springpractice.features.support.actor.IMoodChangerActor;
import ch.alika.springpractice.features.support.actor.domain.GreetingGetterActor;
import ch.alika.springpractice.features.support.actor.domain.MoodChangingActor;
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
    public IMoodChangerActor moodChanger(MoodCenter moodCenter) {
        return new MoodChangingActor(moodCenter);
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public IGreetingGetterActor greetingGetter(MoodCenter moodCenter) {
        return new GreetingGetterActor(moodCenter);
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
