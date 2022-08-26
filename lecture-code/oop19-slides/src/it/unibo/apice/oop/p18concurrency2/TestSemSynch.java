package it.unibo.apice.oop.p18concurrency2;

class AgentA extends Thread {
	private Sem synch;
	public AgentA(Sem synch){
		this.synch = synch;
	}
	public void run(){
		System.out.println("a");
		sleepAbit();
		synch.signal();
	}
	private void sleepAbit(){
		try { Thread.sleep(2000); } catch (Exception ex){}
	}
}

class AgentB extends Thread {
	private Sem synch;
	public AgentB(Sem synch){
		this.synch = synch;
	}
	public void run(){
		synch.await();
		System.out.println("b");
	}
}


public class TestSemSynch {

	public static void main(String[] args) {
		Sem s = new Sem(0);
		new AgentA(s).start();
		new AgentB(s).start();
	}

}
