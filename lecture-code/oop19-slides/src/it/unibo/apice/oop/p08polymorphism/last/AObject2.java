package it.unibo.apice.oop.p08polymorphism.last;

/* Everything is an Object, ma quale?? */
public class AObject2 {
	public static void main(String[] s) {
		final Object[] os = new Object[5];
		os[0] = new Object();
		os[1] = new Integer(10);
		os[2] = new Integer(20);
		os[3] = new int[] { 10, 20, 30 };
		os[4] = new Integer(30);
		printAllAndSum(os);
	}

	/* Voglio anche stampare la somma degli Integer presenti */
	public static void printAllAndSum(final Object[] array) {
		int sum = 0;
		for (final Object o : array) {
			System.out.println("Oggetto:" + o.toString());
			if (o instanceof Integer) { // test a runtime
				final Integer i = (Integer) o; // (down)cast
				sum = sum + i.intValue();
			}
		}
		System.out.println("Somme degli Integer: " + sum);
	}
}
