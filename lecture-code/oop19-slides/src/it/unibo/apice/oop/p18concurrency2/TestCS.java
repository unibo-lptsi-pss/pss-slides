package it.unibo.apice.oop.p18concurrency2;

class MyWorkerA extends Thread {
	private Object lock;
	public MyWorkerA(Object lock){
		this.lock = lock;
	}	
	public void run(){
		while (true){
		  System.out.println("a1");
		  synchronized(lock){
			  System.out.println("a2");
			  System.out.println("a3");
		  }
		}
	}
}

class MyWorkerB extends Thread {
	private Object lock;
	public MyWorkerB(Object lock){
		this.lock = lock;
	}	
	public void run(){
		while (true){
			  System.out.println("b1");
		  synchronized(lock){
			  System.out.println("b2");
			  System.out.println("b3");
		  }
		}
	}
}

public class TestCS {
	public static void main(String[] args) {
		Object lock = new Object();
		new MyWorkerA(lock).start();		
		new MyWorkerB(lock).start();
	}
}
