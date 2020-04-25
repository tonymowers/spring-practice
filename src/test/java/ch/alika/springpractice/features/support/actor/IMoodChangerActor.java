package ch.alika.springpractice.features.support.actor;

import ch.alika.screenplay.ActorInterface;
import ch.alika.springpractice.domain.Mood;

import java.util.List;

@ActorInterface
public interface IMoodChangerActor {

    /*
      Tasks
     */
    void setDefaultMood(Mood mood);

    void setCurrentMood(Mood mood);

    void setCurrentMoodToDefaultMood();

    /*
      Questions
     */
    List<Mood> getAvailableMoods();

    Mood getDefaultMood();

    Mood getCurrentMood();
}
