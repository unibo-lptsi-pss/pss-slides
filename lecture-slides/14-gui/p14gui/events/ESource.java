package it.unibo.apice.oop.p15gui.events;

import java.util.*;

public class ESource {
	
	private Set<EObserver> set = new HashSet<>();
	
	public void addEObserver(EObserver obs){
		this.set.add(obs);
	}
	
	public void notifyEObservers(Object arg){
		for (EObserver obs : this.set){
			obs.update(this, arg);
		}
	}
	
}
