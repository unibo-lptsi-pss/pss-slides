public class UncheckedStackTrace {
    public static void main(String[] args) {
        int[] a = new int[] { 10, 20, 30 };
        int b = accessArray(a, 1); // OK
        int c = accessArray(a, 3); // Eccezione
    }

    public static int accessArray(int[] array, int pos) {
        return array[pos];
    }
}
/*
 * Stampa dell'errore:
 * 
 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
 * at UncheckedStackTrace.accessArray(UncheckedStackTrace.java:9)
 * at UncheckedStackTrace.main(UncheckedStackTrace.java:5)
 */
