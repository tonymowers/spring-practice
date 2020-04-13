package ch.alika.springpractice.features.support.screenplay;

public interface IActorQuestion<T,U> {
    U answeredBy(T actor);
}
