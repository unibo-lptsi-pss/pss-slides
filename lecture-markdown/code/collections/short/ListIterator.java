package java.util;

public interface ListIterator<E> extends Iterator<E> {
    // Query Operations
    boolean hasNext();
    E next();
    boolean hasPrevious();
    E previous();
    int nextIndex();
    int previousIndex();

    // Modification Operations
    void remove();
    void set(E e);
    void add(E e);
}
