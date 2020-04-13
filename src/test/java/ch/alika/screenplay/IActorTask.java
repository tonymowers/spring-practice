package ch.alika.screenplay;

public interface IActorTask<T> {
    void performedBy(T actor);
}
