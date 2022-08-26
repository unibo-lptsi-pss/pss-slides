package it.unibo.apice.oop.p18patterns.observer;

public interface EObserver<T> {
	
	public void update(ESource<? extends T> s, T arg);
	
}
