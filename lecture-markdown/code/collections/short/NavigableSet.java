public interface NavigableSet<E> extends SortedSet<E> {
    E lower(E e);   // Elemento prima di e
    E floor(E e);   // Elemento prima di e (e incluso)
    E ceiling(E e); // Elemento dopo e (e incluso)
    E higher(E e);  // Elemento dopo e
    E pollFirst();  // Torna ed elimina il primo se esiste
    E pollLast();   // Torna ed elimina l'ultimo se esiste
    NavigableSet<E> descendingSet();	// Set con ordine invertito
    Iterator<E> descendingIterator();   // .. e relativo iteratore
    NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
                           E toElement,   boolean toInclusive);
    NavigableSet<E> headSet(E toElement, boolean inclusive);
    NavigableSet<E> tailSet(E fromElement, boolean inclusive);
}
