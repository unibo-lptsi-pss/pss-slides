package it.unibo.apice.oop.p04objects;

public class MagicExample {
	// Put 100 into a constant and give it a name!!
	private static final int SIZE = 100;

	public static void main(String[] s) {
		double[] array = new double[SIZE];
		double sum = 0;
		for (int i = 0; i < SIZE; i++) {
			// Assegno un numero random
			array[i] = Math.random();
			sum = sum + array[i];
		}
		System.out.println("Somma " + sum);
	}
}
