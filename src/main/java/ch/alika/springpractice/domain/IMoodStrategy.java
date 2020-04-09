package ch.alika.springpractice.domain;

public interface IMoodStrategy {
    Mood getMood();
    IGreetingSupplier getGreetingSupplier();
}
