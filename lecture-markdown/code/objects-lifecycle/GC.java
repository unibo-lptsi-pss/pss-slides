package it.unibo.apice.oop.p04objects;

class GC {
	private static long size = 1000;

	public static void main(String[] s) {
		// Runtime dà info sull'esecuzione
		Runtime r = Runtime.getRuntime();

		// Creo oggetti all'infinito
		for (long l = 0; true; l++) {
			new Object();
			// Stampo solo ogni tanto
			if (l % size == 0) {
				System.out.print("Objs (*10^6): " + l / 1000000);
				System.out.println(" Freemem (MB):" + (r.freeMemory() >> 20));
			}
			// La memoria libera si vedrà calare lentamente
			// e poi riprendersi di colpo, ciclicamente
		}
	}
}
