package it.unibo.apice.oop.p22effective.composition;

public class CounterImpl implements Counter {
	
	private int counter = 0;

	@Override
	public int getValue() {
		return this.counter;
	}

	@Override
	public void increment() {
		counter++;
	}
}
