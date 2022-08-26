public interface Comparator<T> {
    // 0 if o2 == o1, pos if o2 > o1, neg if o2 smaller than o2
    int compare(T o1, T o2);
}
