static final class RangeIntSpliterator implements Spliterator.OfInt {
 
        private int from;           // initial
        private final int upTo;	    // final
        private int last;	    // current
        ..
        public boolean tryAdvance(IntConsumer consumer) {
            Objects.requireNonNull(consumer);
            final int i = from;
            if (i < upTo) {
                from++;
                consumer.accept(i);
                return true;
            } else if (last > 0) {
                last = 0;
                consumer.accept(i);
                return true;
            }
            return false;
        }

        public long estimateSize() {
            return ((long) upTo) - from + last;
        }

        public Spliterator.OfInt trySplit() {
            long size = estimateSize();
            return size <= 1
                   ? null
                   : new RangeIntSpliterator(from, from = from + splitPoint(size), 0);
        }
}
