package ch.alika.springpractice.features;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.features.support.actor.IGreetingGetter;
import ch.alika.springpractice.features.support.actor.IMoodChanger;
import ch.alika.springpractice.features.support.actor.domain.GreetedActor;
import ch.alika.springpractice.features.support.actor.domain.MoodChangingActor;
import ch.alika.springpractice.features.support.screenplay.Actor;
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
    public Actor<IMoodChanger> moodCenterActor(MoodCenter moodCenter) {
        return wrapActor(new MoodChangingActor(moodCenter));
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public Actor<IGreetingGetter> greetedActor(MoodCenter moodCenter) {
        return wrapActor(new GreetedActor(moodCenter));
    }

    @Bean
    @Scope(SCOPE_CUCUMBER_GLUE)
    public MoodCenter moodCenter() {
        return new MoodCenter(Arrays.asList(
                new HappyStrategy(),
                new SadStrategy()
        ));
    }

    private <T> Actor<T> wrapActor(T actor) {
        return new Actor<>(actor);
    }
}
