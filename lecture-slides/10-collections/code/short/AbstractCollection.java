package java.util;

public abstract class AbstractCollection<E> implements Collection<E> {

    public abstract Iterator<E> iterator();

    public abstract int size();
    
    /* 1 - The other methods are all implemented
       2 - Method add is here unsupported */
}
