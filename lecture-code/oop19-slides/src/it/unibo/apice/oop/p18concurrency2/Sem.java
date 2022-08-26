package it.unibo.apice.oop.p18concurrency2;

public class Sem {
	private int c; // c >= 0 

	public Sem(int c){
		if (c < 0){
			throw new IllegalArgumentException();
		}
		this.c = c;
	}
	
	public synchronized void await() {
		while (c == 0){
			try {
				wait();
			} catch (InterruptedException ex){}
		}
		c--;
	}
	
	public synchronized void signal(){
		c++;
		notify();
	}
}
