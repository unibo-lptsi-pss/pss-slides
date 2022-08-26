package it.unibo.apice.oop.p12exceptions.classes;

public class UncheckedStackTrace{
    public static void main(String[] args){
    	final int[] a = new int[]{10,20,30};
    	final int b = accessArray(a,1); // OK
    	final int c = accessArray(a,3); // Eccezione
    	final int d = accessArray(a,5); // Eccezione
    }
    
    public static int accessArray(final int[] array, final int pos){
    	return array[pos];
    }
}

/* Stampa dell'errore:

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        at UncheckedStackTrace.accessArray(UncheckedStackTrace.java:9)
        at UncheckedStackTrace.main(UncheckedStackTrace.java:5)
*/
