public interface IntStream extends BaseStream<Integer, IntStream> {

    IntStream filter(IntPredicate predicate);
    IntStream map(IntUnaryOperator mapper);
    ..
    
    int[] toArray();
    int sum();
    OptionalInt min();
    OptionalInt max();
    OptionalDouble average();
    IntSummaryStatistics summaryStatistics();
    
    LongStream asLongStream();
    DoubleStream asDoubleStream();
    Stream<Integer> boxed();

    public static IntStream empty() {..}
    public static IntStream of(int t) {..}
    public static IntStream of(int... values) {..}
    public static IntStream iterate(final int seed, final IntUnaryOperator f) {..}
    public static IntStream generate(IntSupplier s) {..}
    public static IntStream range(int startInclusive, int endExclusive) {..}
    public static IntStream rangeClosed(int startInclusive, int endInclusive) {..}
    public static IntStream concat(IntStream a, IntStream b) {..}
}
 
