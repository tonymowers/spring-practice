package ch.alika.springpractice.features.support.screenplay;

public interface IActorTask<T> {
    void performedBy(T actor);
}
