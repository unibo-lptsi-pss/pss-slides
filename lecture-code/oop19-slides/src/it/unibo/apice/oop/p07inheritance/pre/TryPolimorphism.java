package it.unibo.apice.oop.p07inheritance.pre;

public class TryPolimorphism {

	public static void main(String[] args) {
		final Counter c = new Counter(0);
		c.increment();
		c.increment();
		int i = c.getValue();
	}

}
