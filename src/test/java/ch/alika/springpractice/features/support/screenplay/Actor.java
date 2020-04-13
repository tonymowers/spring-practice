package ch.alika.springpractice.features.support.screenplay;

public class Actor<T> {
    private T performer;

    public Actor(T performer) {
        this.performer = performer;
    }

    public void wasAbleTo(IActorTask<T> task) {
        task.performedBy(performer);
    }

    public void attemptsTo(IActorTask<T> task) {
        task.performedBy(performer);
    }

    public <U> U shouldSee(IActorQuestion<T,U> question) {
        return question.answeredBy(performer);
    }
}
