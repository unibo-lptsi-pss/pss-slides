public interface List<E> extends Collection<E> {
    // Additional Bulk Operations 
    // aggiunge gli elementi in pos. index
    boolean addAll(int index, Collection<? extends E> c); 

    // Positional Access Operations
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);

    // Search Operations
    int indexOf(Object o);	// basato su Object.equals
    int lastIndexOf(Object o);  // basato su Object.equals

    // List Iterators
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);

    // View
    List<E> subList(int fromIndex, int toIndex);
}
