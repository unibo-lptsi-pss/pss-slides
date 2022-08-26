package it.unibo.apice.oop.p15gui.events;

import java.util.*;

public class Adder extends ESource implements EObserver{
	
	// Somma degli elementi giunti finora
	private int sum = 0;

	// Alla notifica..
	public void update(ESource o, Object arg) {
		if (((Integer)arg)==-1){ 
			// Se -1 notifico a mia volta
			this.notifyEObservers(sum);
		} else {
			// Altrimenti sommo
			sum += (Integer)arg;
		}
	}
}
