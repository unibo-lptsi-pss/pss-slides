public interface Collection<E> extends Iterable<E> {

    ..

    Iterator<E> iterator();

    default boolean removeIf(Predicate<? super E> filter) {..}

    default Spliterator<E> spliterator() {..}
    
    default Stream<E> stream() {..}
    
    default Stream<E> parallelStream() {..}
}
 
