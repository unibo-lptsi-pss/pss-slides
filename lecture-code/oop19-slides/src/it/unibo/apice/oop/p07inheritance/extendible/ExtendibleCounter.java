package it.unibo.apice.oop.p07inheritance.extendible;

/* Il nome ExtendibleCounter è di comodo, più propriamente
 andrebbe chiamata semplicemente Counter */

public class ExtendibleCounter {

    /* campo value protetto */
    protected int value;

    public ExtendibleCounter(final int initialValue) {
        this.value = initialValue;
    }

    public void increment() {
        this.value++;
    }

    public int getValue() {
        return this.value;
    }
}
