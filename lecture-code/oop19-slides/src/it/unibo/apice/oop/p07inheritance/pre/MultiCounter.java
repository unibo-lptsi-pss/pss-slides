package it.unibo.apice.oop.p07inheritance.pre;

public class MultiCounter {

    private int value;

    public MultiCounter(final int initialValue) {
        this.value = initialValue;
    }

    public void increment() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }

    /* Nuovo metodo */
    public void multiIncrement(final int n) {
        for (int i = 0; i < n; i++) {
            this.increment();
        }
    }
}
