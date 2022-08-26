package it.unibo.apice.oop.p18concurrency1;


public class CounterEvent {
	private int value;
	public CounterEvent(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
}
