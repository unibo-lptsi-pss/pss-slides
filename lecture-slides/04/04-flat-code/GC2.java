

class GC2 {
	long l;

	GC2(long l) { // Un oggetto GC2 ha un campo long
		this.l = l;
	}

	public void finalize() { // Quando finalizzato stampo l
		System.out.println("GCing n." + this.l);
	}

	private static long size = 1000;

	public static void main(String[] s) throws Exception {
		Runtime r = Runtime.getRuntime();
		for (long l = 0; true; l++) {
			new GC2(l);
			if (l % size == 0) {
				System.out.print("Objs (*10^6): " + l / 1000000);
				System.out.println(" Freemem (MB):" + (r.freeMemory() >> 20));
			}
		}
	}
}
