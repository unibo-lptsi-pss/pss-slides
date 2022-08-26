package it.unibo.apice.oop.p19reflection.classes;

import java.util.HashSet;
import java.util.Set;

public class Initializers {
	
	static { // static initializer.. è eseguito "subito"
		System.out.println("Static initializer executed...");
		SET = Set.of(10,20,30); // ad esempio inizializza i campi statici
	}
	
	{	// non-static initializer.. è eseguito prima del costruttore
		System.out.println("Non-static initializer executed...");
		set = Set.of(10,20,30,40);
	}
	
	Initializers(){
		System.out.println("Constructor executed...");
	}
	
	private static final Set<Integer> SET;
	private final Set<Integer> set;
	// use of non-static initializers with anonymous classes
	private final Set<Integer> set2 = new HashSet<>() {{ add(1); add(2); }};

	public static void main(String[] args) {
		System.out.println("Let's create an object..");
		Initializers i = new Initializers();
		System.out.println(i.set2);
	}

}
