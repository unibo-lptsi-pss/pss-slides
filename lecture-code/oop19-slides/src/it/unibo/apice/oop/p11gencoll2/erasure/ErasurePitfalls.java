package it.unibo.apice.oop.p11gencoll2.erasure;

import java.util.ArrayList;
import java.util.List;

class P<X> {
	void m() {
		X x = (X)new Object(); // warning
		// X x = new X(); // error
		X[] a = (X[])new Object[10]; // warning
		// X[] a = new X[10]; // error
		// boolean b = new Object() instanceof X; // error		
	}
}

public class ErasurePitfalls {

	public static void main(String[] args) {
		Object o = (List<String>)new Object();
		// boolean b = new Object() instanceof List<String> // error
		// Object o = new List<Pair>[10]; // error
	}

}
