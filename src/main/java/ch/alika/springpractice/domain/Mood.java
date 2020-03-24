package ch.alika.springpractice.domain;

import lombok.Value;

@Value
public class Mood {
    String id;
    String name;

    public static final Mood NULL_MOOD = new Mood("NULL", "NULL");

}
