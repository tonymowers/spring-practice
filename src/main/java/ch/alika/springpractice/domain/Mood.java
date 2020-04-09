package ch.alika.springpractice.domain;

import lombok.Value;

@Value
public class Mood {
    public static final Mood NULL_MOOD = new Mood("NULL", "NULL");

    String id;
    String name;
}
