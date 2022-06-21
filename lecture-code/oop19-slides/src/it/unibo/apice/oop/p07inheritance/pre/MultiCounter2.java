package it.unibo.apice.oop.p07inheritance.pre;

public class MultiCounter2 {

    private Counter counter;

    public MultiCounter2(final int initialValue) {
        this.counter = new Counter(initialValue);
    }

    public void increment() {
        this.counter.increment();
    }

    public int getValue() {
        return this.counter.getValue();
    }

    /* Nuovo metodo */
    public void multiIncrement(final int n) {
        for (int i = 0; i < n; i++) {
            this.counter.increment();
        }
    }
}
