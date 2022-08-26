
public class Arrays {
    public static void sort(Object[] a, int fromIndex, int toIndex) {...}
    public static <T> void sort(T[] a, Comparator<? super T> c) {...}
    ...
    public static int binarySearch(int[] a, int key) {...}
    public static int binarySearch(char[] a, char key) {...}
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {...}
    ...
    public static <T> List<T> asList(T... a) {...}
    public static <T> T[] copyOfRange(T[] original, int from, int to) {...}
    public static void fill(Object[] a, int from, int to, Object val) {...}
    	
    public static boolean deepEquals(Object[] a1, Object[] a2) {...}
    public static int deepHashCode(Object a[]) {...}
    public static String deepToString(Object[] a) {...}
    
    public static String toString(long[] a) {...}
    public static String toString(int[] a) {...}
    public static String toString(Object[] a) {...}

}
