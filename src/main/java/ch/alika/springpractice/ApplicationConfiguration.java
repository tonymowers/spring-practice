package ch.alika.springpractice;

import ch.alika.springpractice.domain.MoodCenter;
import ch.alika.springpractice.domain.moodimpl.HappyStrategy;
import ch.alika.springpractice.domain.moodimpl.SadStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MoodCenter moodCenter() {
        return new MoodCenter(Arrays.asList(
                new HappyStrategy(),
                new SadStrategy()
        ));
    }
}
