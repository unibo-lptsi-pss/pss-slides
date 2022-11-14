public interface List<E> extends Collection<E> {
    // Additional Bulk Operations 
    boolean addAll(int index, Collection<? extends E> c);

    // Positional Access Operations
    E get(int index);               // get at position index
    E set(int index, E element);    // set into position index
    void add(int index, E element); // add, shifting others
    E remove(int index);            // remove at position index

    // Search Operations
    int indexOf(Object o);          // first equals to o
    int lastIndexOf(Object o);      // last equals to o

    // List Iterators (enable traversal in both directions, modifications etc.)
    ListIterator<E> listIterator();           // iterator from 0
    ListIterator<E> listIterator(int index);  // ..from index

    // View
    List<E> subList(int fromIndex, int toIndex);
}
