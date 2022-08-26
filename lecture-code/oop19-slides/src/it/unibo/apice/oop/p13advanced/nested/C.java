package it.unibo.apice.oop.p13advanced.nested;

class C {

	// Prima
	Object m(final int x) {
		return new Object() {
			public String toString() {
				return " Valgo " + x;
			}
		};
	}
	
	// Dopo
	Object m2(final int x) {
		class Anonymous extends Object{
			public String toString() {
				return " Valgo " + x;
			}
		}
		return new Anonymous();
	}

}
