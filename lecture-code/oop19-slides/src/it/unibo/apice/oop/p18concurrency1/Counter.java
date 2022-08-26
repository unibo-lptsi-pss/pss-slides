package it.unibo.apice.oop.p18concurrency1;

import java.util.*;

public class Counter {
	
	private ArrayList<CounterEventListener> listeners;
	private int cont;
	private int base;
	
	public Counter(int base){
		this.cont = base;
		this.base = base;
		listeners = new ArrayList<CounterEventListener>();
	}
	
	public void inc(){
		cont++;
		System.out.println("count "+cont);
		notifyEvent(new CounterEvent(cont));
	}
	
	public void reset(){
		cont = base;
		notifyEvent(new CounterEvent(cont));
	}
	
	public int getValue(){
		return cont;
	}
	
	public void addListener(CounterEventListener l){
		listeners.add(l);
	}
	
	private void notifyEvent(CounterEvent ev){
		for (CounterEventListener l: listeners){
			l.counterChanged(ev);
		}
	}
}
