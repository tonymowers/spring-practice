package ch.alika.springpractice.features.support.actor;

import ch.alika.screenplay.ActorInterface;
import ch.alika.screenplay.ActorQuestion;
import ch.alika.screenplay.ActorTask;
import ch.alika.springpractice.domain.Mood;

import java.util.List;

@ActorInterface
public interface IMoodChangerActor {

    /*
      Tasks
     */
    @ActorTask
    void setDefaultMood(Mood mood);

    @ActorTask
    void setCurrentMood(Mood mood);

    @ActorTask
    void setCurrentMoodToDefaultMood();

    /*
      Questions
     */
    @ActorQuestion
    List<Mood> getAvailableMoods();

    @ActorQuestion
    Mood getDefaultMood();

    @ActorQuestion
    Mood getCurrentMood();
}
