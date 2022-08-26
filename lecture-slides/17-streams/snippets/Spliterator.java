public interface Spliterator<T> {

    boolean tryAdvance(Consumer<? super T> action);

    default void forEachRemaining(Consumer<? super T> action) {..}

    Spliterator<T> trySplit();

    long estimateSize();

    default long getExactSizeIfKnown() {..}

    int characteristics();

    default boolean hasCharacteristics(int characteristics) {..}
    
    default Comparator<? super T> getComparator() {
        throw new IllegalStateException();
    }

    public static final int ORDERED    = 0x00000010;
    public static final int DISTINCT   = 0x00000001;
    public static final int SORTED     = 0x00000004;
    public static final int SIZED      = 0x00000040;
    public static final int NONNULL    = 0x00000100;
    public static final int IMMUTABLE  = 0x00000400;
    public static final int CONCURRENT = 0x00001000;
    public static final int SUBSIZED = 0x00004000;
}
 
