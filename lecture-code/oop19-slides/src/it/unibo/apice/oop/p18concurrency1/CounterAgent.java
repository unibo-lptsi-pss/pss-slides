package it.unibo.apice.oop.p18concurrency1;

public class CounterAgent extends Thread{
	private Counter counter;
	private volatile boolean stopped;
	
	public CounterAgent(Counter c){
		counter = c;
	}
	public void run(){
		stopped = false;
		while (!stopped){
			counter.inc();
			System.out.println(counter.getValue());
			try {
				Thread.sleep(10);
			} catch(Exception ex){
			}
		}
	}
	public void interrupt(){
		super.interrupt();
		stopped = true;
	}
}
