package it.unibo.apice.oop.p18concurrency1;

class PrimeWorker extends Thread {
	
	private int base;
	private int nNumbers;
	
	public PrimeWorker(int base, int nNumbers){
		this.base = base;
		this.nNumbers = nNumbers;
	}
	
	public void run(){
		for (int i = base+1; i <= base+nNumbers; i++){
			if (isPrime(i)){
				System.out.println(""+i);
			}
		}
	}

	private boolean isPrime(int num){
		int sq = (int)Math.sqrt(num);
		for (int i=2; i<=sq /* && !stopped */; i++){
			if ((num % i)==0){
				return false;
			}
		}
		return true;
	}
}
