package it.unibo.apice.oop.p07inheritance.extendible;

public class LimitCounter extends ExtendibleCounter {

    /* Aggiungo un campo, che tiene il limite */
    protected final int limit;

    public LimitCounter(final int limit) {
        super(0);
        this.limit = limit;
    }

    public boolean isOver() {
        return this.getValue() == this.limit;
    }

    /* Overriding del metodo increment() */
    public void increment() {
        if (!this.isOver()) {
            super.increment();
        }
    }
}
