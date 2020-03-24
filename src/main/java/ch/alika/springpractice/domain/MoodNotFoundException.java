package ch.alika.springpractice.domain;

public class MoodNotFoundException extends RuntimeException {
    public MoodNotFoundException(String msg) {
        super(msg);
    }
}
