public class Counter {
	private int value; // o protected..

	public Counter(int initialValue) {
		this.value = initialValue;
	}

	public void increment() {
		this.value++;
	}

	public int getValue() {
		return this.value;
	}

	public static class Multi extends Counter {
	    ... // solito codice
	}

	public static class Bidirectional extends Counter {
	    ... // solito codice
	}
}
