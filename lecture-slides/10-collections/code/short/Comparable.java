public interface Comparable<T> {
    /* returns: 0 (this == o), positive (this > o)
                	       negative (this < o) */
    public int compareTo(T o);
}
