public class TreeSet<E> extends AbstractSet<E>
    implements NavigableSet<E>, Cloneable, java.io.Serializable{
    
    // Set vuoto di elementi confrontabili
    public TreeSet() {...}

    // Set vuoto con comparatore fornito
    public TreeSet(Comparator<? super E> comparator) {...}
    
    // Set con gli elementi di c, confrontabili tra loro
    public TreeSet(Collection<? extends E> c) {...}

    // Set con gli elementi di c, e che usa il loro ordering
    public TreeSet(SortedSet<E> s) {...}
    
    /* Seguono i metodi di NavigableSet e SortedSet */
}
