package it.unibo.apice.oop.p08polymorphism.last;

public class VarArgs {
	// somma un numero variabile di Integer
	public static int sum(final Integer... args) {
		int sum = 0;
		for (int i : args) {
			sum = sum + i;
		}
		return sum;
	}

	// stampa il contenuto degli argomenti, se meno di 10
	public static void printAll(final String start, final Object... args) {
		System.out.println(start);
		if (args.length < 10) {
			for (final Object o : args) {
				System.out.println(o);
			}
		}
	}

	public static void main(String[] s) {
		System.out.println(sum(10, 20, 30, 40, 50, 60, 70, 80));
		printAll("inizio", 1, 2, 3.2, true, new int[] { 10 }, new Object());
		
		System.out.format("%d %d\n", 10, 20); // C-like printf
	}
}
