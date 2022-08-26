package it.unibo.apice.oop.p18concurrency1;
import java.util.*;

public class Clock extends Thread {
	private int step;
	public Clock(int step){
		this.step=step;
	}
	public void run(){
		while (true) {
			System.out.println(new Date());
			try {
				sleep(step);
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
