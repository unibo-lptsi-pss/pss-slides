public interface Map<K,V> {

    // Query Operations
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);        // usa Object.equals
    boolean containsValue(Object value);    // usa Object.equals
    V get(Object key);                      // accesso a valore

    // Modification Operations
    V put(K key, V value);          // inserimento chiave-valore
    V remove(Object key);           // rimozione chiave(-valore)

    // Bulk Operations
    void putAll(Map<? extends K, ? extends V> m);
    void clear();                   // cancella tutti

    // Views
    Set<K> keySet();                    // set di chiavi
    Collection<V> values();             // collezione di valori
    Set<Map.Entry<K, V>> entrySet();    // set di chiavi-valore
    
    interface Entry<K,V> {...}          // public static implicito!
}
