public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable {

    // Set vuoto, usa hashmap con capacità 16
    public HashSet() {...}
    
    // Set con elementi di c, usa hashmap del 25% più grande di c
    public HashSet(Collection<? extends E> c) {...}

    // Set vuoto
    public HashSet(int initialCapacity, float loadFactor) {...}

    // Set vuoto, loadFactor = 0.75
    public HashSet(int initialCapacity) {...}
    
    /* Gli altri metodi di Collection seguono... */
}
