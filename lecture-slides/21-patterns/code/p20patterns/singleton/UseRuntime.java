package it.unibo.apice.oop.p18patterns.singleton;

public class UseRuntime {
	public static void main(String[] s){
		
		// r punta l'unico oggetto di Runtime
		Runtime r = Runtime.getRuntime();
		System.out.println(r.availableProcessors());
		System.out.println(r.freeMemory());
		
		// Accessibile anche senza depositare in r
		System.out.println(Runtime.getRuntime().maxMemory());
		
		// Questa soluzione a volte ritenuta migliore rispetto a
		// classi con solo metodi statici
		// Anche java.lang.Math poteva essere gestita così
	}
}
