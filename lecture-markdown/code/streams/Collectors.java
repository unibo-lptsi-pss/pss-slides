class Collectors { // some methods, all public static and generic..
   
    Collector<T, ?, C> toCollection(Supplier<C> collectionFactory) 
    Collector<T, ?, List<T>> toList() 
    Collector<T, ?, Set<T>> toSet() 
    
    Collector<CharSequence, ?, String> joining(CharSequence delimiter,
                                               CharSequence prefix,
                                               CharSequence suffix) 
                                                             
    Collector<T, ?, Optional<T>>  minBy(Comparator<? super T> comparator) 
    Collector<T, ?, Optional<T>>  maxBy(Comparator<? super T> comparator) 
    
    Collector<T, ?, Integer> summingInt(ToIntFunction<? super T> mapper) 
    Collector<T, ?, Long> summingLong(ToLongFunction<? super T> mapper)     
    
    Collector<T, ?, Map<K, List<T>>> groupingBy(Function<? super T, ? extends K> classifier) 
    
    Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector<? super T, A, D> downstream) 
    
    Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper) 

    Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper,
                                    BinaryOperator<U> mergeFunction) 
                                       
    Collector<T, ?, DoubleSummaryStatistics> 
                              summarizingDouble(ToDoubleFunction<? super T> mapper) 
}
 
