public interface Collection<E> extends Iterable<E> {

    // Query Operations
    int size();	                // number of elements
    boolean isEmpty();          // is the size zero?
    boolean contains(Object o); // does it contain an element equal to o?
    Iterator<E> iterator();     // yields an iterator
    Object[] toArray();	        // convert to array of objects
    <T> T[] toArray(T[] a);     // puts in `a`, or create new if too small

    // Modification Operations
    boolean add(E e);           // adds e
    boolean remove(Object o);   // remove one element that is equal to o

    // Bulk Operations
    boolean containsAll(Collection<?> c);       // contain all elements in c?
    boolean addAll(Collection<? extends E> c);  // add all elements in c
    boolean removeAll(Collection<?> c);         // remove all elements in c
    boolean retainAll(Collection<?> c);         // keep only elements in c
    void clear();                               // remove all element
    
    // ...and other methods introduced in Java 8
}
