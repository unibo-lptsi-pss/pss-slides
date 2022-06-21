package it.unibo.apice.oop.p07inheritance.ered;

public class Counter {

    private int counter;

    public Counter(final int initialValue) {
        this.counter = initialValue;
    }

    public void increment() {
        this.counter++;
    }

    public int getValue() {
        return counter;
    }
}
