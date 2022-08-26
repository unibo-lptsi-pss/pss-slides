package it.unibo.apice.oop.p18concurrency2;

import java.util.concurrent.*;

public class TestCSwithSem2 {
	public static void main(String[] args) {
		Semaphore mutex= new Semaphore(1);
		new MyWorkerA(mutex).start();		
		new MyWorkerB(mutex).start();
	}

	class MyAgentA extends Thread {
		private Semaphore mutex;
		public MyAgentA(Semaphore mutex){
			this.mutex = mutex;
		}	
		public void run(){
			while (true){
			  System.out.println("a1");
			  try {
				  mutex.acquire();
				  System.out.println("a2");
				  System.out.println("a3");
				  mutex.release();
			  } catch (InterruptedException ex){}
			}
		}
	}

	class MyAgentB extends Thread {
		private Semaphore mutex;
		public MyAgentB(Semaphore mutex){
			this.mutex = mutex;
		}	
		public void run(){
			while (true){
			  try {
				System.out.println("b1");
				mutex.acquire();
				System.out.println("b2");
				System.out.println("b3");
				mutex.release();
			  } catch (Exception ex){}
			}
		}
	}


}
