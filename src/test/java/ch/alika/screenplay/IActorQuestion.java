package ch.alika.screenplay;

public interface IActorQuestion<T,U> {
    U answeredBy(T actor);
}
