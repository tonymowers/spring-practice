package ch.alika.springpractice.domain;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
