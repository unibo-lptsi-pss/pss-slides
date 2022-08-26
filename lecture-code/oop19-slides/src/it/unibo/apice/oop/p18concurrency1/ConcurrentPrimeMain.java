package it.unibo.apice.oop.p18concurrency1;

public class ConcurrentPrimeMain {	
	public static void main(String[] args){		
		if (args.length!=2){
			System.err.println("Args: <N primes> <N threads>");
			System.exit(1);			
		}
		try {			
			int n = Integer.parseInt(args[0]);
			int t = Integer.parseInt(args[1]);
			int nNumbers = n / t;
			int base = 0;
			for (int i=0; i < t-1; i++){
				new PrimeWorker(base,nNumbers).start();
				base+=nNumbers;
			}
			new PrimeWorker(base,n-base).start();
		} catch(Exception ex){
			System.err.println("Wrong arguments.");
			System.exit(2);			
		}
		
	}
}
