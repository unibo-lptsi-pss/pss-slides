package it.unibo.apice.oop.p07inheritance.example;

public class LimitCounter extends ExtendibleCounter {

    private final int limit;

    public LimitCounter(final int initialValue, final int limit) {
        super(initialValue);
        this.limit = limit;
    }

    public boolean isOver() {
        return this.getDistanceToLimit() == 0;
    }

    public int getDistanceToLimit() {
        return this.limit - this.value;
    }

    public void increment() {
        if (!this.isOver()) {
            super.increment();
        }
    }
}
