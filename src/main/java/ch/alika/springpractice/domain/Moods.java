package ch.alika.springpractice.domain;

import lombok.Value;

public class Moods {
    public static final Mood NULL_MOOD = new NullMood();

    public static Mood createSimpleMood(int id, String name) {
        return new SimpleMood(id,name);
    }

    @Value
    private static class NullMood implements Mood {
        int id;
        String name;

        NullMood() {
            id = -1;
            name = "NULL";
        }
    }

    @Value
    private static class SimpleMood implements Mood {
        int id;
        String name;
    }
}
