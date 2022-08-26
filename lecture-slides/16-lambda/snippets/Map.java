public interface Map<K,V> {
    ...
    
    default V getOrDefault(Object key, V defaultValue) {..}

    default void forEach(BiConsumer<? super K, ? super V> action) {..}
    
    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {..}
    
    default V putIfAbsent(K key, V value) {..}
    
    default boolean remove(Object key, Object value) {..}
    
    default boolean replace(K key, V oldValue, V newValue) {..}
    
    default V replace(K key, V value) {..}
    
    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {..}
    
    default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {..}
    
    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {..}
    
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {..}
}
