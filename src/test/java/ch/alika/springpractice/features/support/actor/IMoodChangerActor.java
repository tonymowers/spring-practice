package ch.alika.springpractice.features.support.actor;

import ch.alika.springpractice.domain.Mood;

import java.util.List;

public interface IMoodChangerActor extends IActor {

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
