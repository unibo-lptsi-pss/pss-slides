package it.unibo.apice.oop.p21patterns.singleton;

public class UseRuntime {
	public static void main(String[] s){
		
		// r punta l'unico oggetto di Runtime
		final Runtime r = Runtime.getRuntime();
		System.out.println(r.availableProcessors());
		System.out.println(r.freeMemory());
		
		// Accessibile anche senza depositare in r
		System.out.println(Runtime.getRuntime().maxMemory());
		
		/*
		 *  Questa soluzione è migliore rispetto a utility class con 
		 *  solo metodi statici, specialmente quando l'implementazione 
		 *  potrebbe fornire istanze di tipo diverso a seconda 
		 *  del contesto di esecuzione specifico.
		 *  Quindi è ok che java.lang.Math sia una utility class
		 */  
	}
}
