package it.unibo.apice.oop.p18concurrency2;

class MyAgentA extends Thread {
	private Sem mutex;
	public MyAgentA(Sem mutex){
		this.mutex = mutex;
	}	
	public void run(){
		while (true){
		  System.out.println("a1");
		  mutex.await();
		  System.out.println("a2");
		  System.out.println("a3");
		  mutex.signal();
		}
	}
}

class MyAgentB extends Thread {
	private Sem mutex;
	public MyAgentB(Sem mutex){
		this.mutex = mutex;
	}	
	public void run(){
		while (true){
		  System.out.println("b1");
		  mutex.await();
		  System.out.println("b2");
		  System.out.println("b3");
		  mutex.signal();
		}
	}
}

public class TestCSwithSem {
	public static void main(String[] args) {
		Sem mutex= new Sem(1);
		new MyWorkerA(mutex).start();		
		new MyWorkerB(mutex).start();
	}
}
