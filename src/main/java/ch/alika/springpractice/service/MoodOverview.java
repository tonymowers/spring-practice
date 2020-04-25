package ch.alika.springpractice.service;

import ch.alika.springpractice.domain.Mood;
import lombok.Value;

import java.util.List;

@Value
public class MoodOverview {
    Mood currentMood;
    Mood defaultMood;
    List<Mood> allMoods;
}
