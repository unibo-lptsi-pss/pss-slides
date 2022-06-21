/* Versione interfaccia */
public interface Counter{
    void increment();
    int getValue();
} 

/* Versione classe astratta */
public abstract class Counter{
    public abstract void increment();
    public abstract int getValue();
} 
