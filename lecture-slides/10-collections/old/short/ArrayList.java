public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
    public ArrayList(int initialCapacity) {...}

    // Usa un valore di default per la capacità iniziale (10)
    public ArrayList() {...}
    
    // Riempe coi valori di c
    public ArrayList(Collection<? extends E> c) {...}

    // Riduce la dimensione dell'array interno 
    public void trimToSize() {...}

    // Aumenta la dimensione dell'array interno
    public void ensureCapacity(int minCapacity) {...}
    
}
