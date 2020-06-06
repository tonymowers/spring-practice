package ch.alika.springpractice.features.support.actor;

import ch.alika.screenplay.ActorInterface;
import ch.alika.screenplay.ActorQuestion;

@ActorInterface
public interface IGreetingGetterActor {

    /*
       Questions
     */
    @ActorQuestion
    String getGreeting();
}
