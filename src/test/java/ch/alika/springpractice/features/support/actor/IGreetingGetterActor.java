package ch.alika.springpractice.features.support.actor;

import ch.alika.screenplay.ActorInterface;

@ActorInterface
public interface IGreetingGetterActor {

    /*
       Questions
     */
    String getGreeting();
}
