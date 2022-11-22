package nested;

public class Counter {

	protected int value;

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

		public Multi(int initialValue) {
			super(initialValue);
		}

		public void multiIncrement(int n) {
			for (int i = 0; i < n; i++) {
				this.increment();
			}
		}
	}

	public static class Bidirectional extends Counter {

		public Bidirectional(int initialValue) {
			super(initialValue);
		}

		public void decrement() {
			this.value--;
		}
	}
}
