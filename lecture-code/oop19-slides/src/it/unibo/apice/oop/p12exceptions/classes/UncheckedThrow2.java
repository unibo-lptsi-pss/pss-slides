package it.unibo.apice.oop.p12exceptions.classes;

public class UncheckedThrow2{
    public static void main(String[] args){
    	final int[] a = new int[]{10,20,30};
    	final int b = accessArray(a,1); // OK
    	final int c = accessArray(a,3); // Eccezione
    }
    
    public static int accessArray(final int[] array, final int pos){
    	if (pos < 0 || pos >= array.length){
    		final String msg = "Accesso fuori dai limiti, in posizione "+pos;
    		RuntimeException e = new java.lang.IllegalArgumentException(msg);
    		throw e;
    	}
    	return array[pos];
    }
}