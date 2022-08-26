package it.unibo.apice.oop.p21patterns.observer;

import java.util.*;

public class SetWithEvents<T> extends ESource<Integer>{
	
	// Incapsula un Set
	private final Set<T> set = new HashSet<>();
	
	// Ad ogni aggiunta notifica la nuova dimensione
	public void add(T t){
		this.set.add(t);
		this.notifyEObservers(set.size());
	}
	
	public Set<T> getCopy(){
		return Collections.unmodifiableSet(this.set);
	}
}
