public class Counter {

	...
	// Codice della classe senza modifiche..
	public static class Multi extends Counter {

		public Multi(int initialValue) {
			super(initialValue);
		}

		public void multiIncrement(int n) {
			for (int i = 0; i < n; i++) {
				this.increment();
			}
		}
	}...

	public static class Bidirectional extends Counter{
	    ... // solito codice
	}
}
