package it.unibo.apice.oop.p22effective.composition;

public class MultiCounterImpl{

	private final Counter c = new CounterImpl();

	private int getValue() {
		return this.c.getValue();
	}

	public void inc() {
		this.c.increment();
	}

	public void multiIncrement(int n) {
		for (int i=0; i<n ; i++){
			this.c.increment();
		}
	}
}
