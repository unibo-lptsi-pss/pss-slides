package it.unibo.apice.oop.p05encapsulation;

public class UseCounter {
	
	public static void main(String[] args) {
		Counter c = new Counter();
		System.out.println(c.getValue()); // 0
		c.increment();
		c.increment();
		c.increment();
		c.increment();
		System.out.println(c.getValue()); // 4
	}
}
