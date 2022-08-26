package it.unibo.apice.oop.p18patterns.observer;

import java.util.*;

public class SetWithEvents<T> extends ESource<Integer>{
	
	// Incapsula un Set
	private Set<T> set = new HashSet<>();
	
	// Ad ogni aggiunta notifica la nuova dimensione
	public void add(T t){
		this.set.add(t);
		this.notifyEObservers(set.size());
	}
	
	public Set<T> getCopy(){
		return new HashSet<>(this.set);
	}
}
