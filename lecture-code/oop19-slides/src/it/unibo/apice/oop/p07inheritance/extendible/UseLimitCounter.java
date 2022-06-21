package it.unibo.apice.oop.p07inheritance.extendible;

public class UseLimitCounter {
	public static void main(String[] s) {
		final LimitCounter c = new LimitCounter(5);
		System.out.println(c.getValue()); // 0
		System.out.println(c.isOver()); // false
		c.increment();
		c.increment();
		System.out.println(c.getValue()); // 2
		System.out.println(c.isOver()); // false
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		System.out.println(c.getValue()); // 5
		System.out.println(c.isOver()); // true
	}
}
