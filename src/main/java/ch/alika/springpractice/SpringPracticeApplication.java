package ch.alika.springpractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringPracticeApplication {

    public static void main(String[] args) {
        log.info("Start spring-practice application");
        SpringApplication.run(SpringPracticeApplication.class, args);
    }

}
