package it.unibo.apice.oop.p18concurrency2;

import java.util.concurrent.Semaphore;

class Fork {
    
    private Semaphore mutex;
    private int id;
    
    public Fork(int id){
        mutex = new Semaphore(1);
        this.id = id;
    }
    
    public int getId(){
    	return id;
    }
    
    public void acquire(){
        try {
        	mutex.acquire();
        } catch (InterruptedException ex){}
    }
    
    public void release(){
        mutex.release();
    }
}

class Philosopher extends Thread {
  private Fork leftFork, rightFork;
  
  public Philosopher(String name, Fork leftFork, Fork rightFork){
	super(name);
	if (leftFork.getId() < rightFork.getId()){
	    this.leftFork = leftFork;
	    this.rightFork = rightFork;
	} else {
	    this.leftFork = rightFork;
	    this.rightFork = leftFork;
	}
  }

  public void run(){
    while (true){
	    think();
	    leftFork.acquire();
	    rightFork.acquire();
	    eat();
	    leftFork.release();
	    rightFork.release();
   	}
  }
  
  private void eat() { System.out.println("["+getName()+"] Eating."); }
  private void think() { System.out.println("["+getName()+"] Thinking..."); }
  
}

public class TestPhilo {
  public static void main(String args[]){     
    Fork[] forks = new Fork[5];
    for (int i = 0; i < forks.length; i++){
      forks[i] = new Fork(i);
    }
    Philosopher philos[] = new Philosopher[5];        
    for (int i = 0; i < 5; i++){
      philos[i] = new Philosopher("Philo-"+i,forks[i],forks[(i+1)%5]);
      philos[i].start();
    }
  }
}