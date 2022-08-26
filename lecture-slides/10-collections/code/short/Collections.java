// nota: tutti metodi public static!!
public class Collections { 
    // ordinamenti e varie
    <T extends Comparable<? super T>> void sort(List<T> list) {...}
    <T> void sort(List<T> list, Comparator<? super T> c) {...}
    <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
    <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)
    
    // modifiche
    void reverse(List<?> list) {...}
    void shuffle(List<?> list) {...}
    <T> void fill(List<? super T> list, T obj) {...}
    <T> void copy(List<? super T> dest, List<? extends T> src) {...}
    
    // letture varie
    int indexOfSubList(List<?> source, List<?> target) {...}
    boolean disjoint(Collection<?> c1, Collection<?> c2) {...}
    int frequency(Collection<?> c, Object o) {...}
    
    // costruzioni di collezioni
    <T> List<T> emptyList() {...} 
    <T> Set<T> emptySet() {...} 
    <T> List<T> nCopies(int n, T o) {...}
    <T> Set<T> singleton(T o) {...}
    <T> List<T> singletonList(T o) {...}
}
