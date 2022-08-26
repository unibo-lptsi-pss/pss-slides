public interface Comparator<T> {
    // 0 if o1 == o2, neg if o1 < o2, pos is o1 > o2
    int compare(T o1, T o2);
}
