package ch.alika.springpractice.features.support.performables;

import ch.alika.springpractice.features.support.actor.IGreetingGetter;
import ch.alika.screenplay.IActorQuestion;

public class GreetingQuestions {

    public static IActorQuestion<IGreetingGetter,String> Greeting() {
        return IGreetingGetter::getGreeting;
    }
}
