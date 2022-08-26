package it.unibo.apice.oop.p21patterns.observer;

import java.util.*;

public class ESource<T> {
	
	private final Set<EObserver<? super T>> set = new HashSet<>();
	
	public void addEObserver(EObserver<? super T> obs){
		this.set.add(obs);
	}
	
	public void notifyEObservers(T arg){
		for (final EObserver<? super T> obs : this.set){
			obs.update(this, arg);
		}
	}
	
}
