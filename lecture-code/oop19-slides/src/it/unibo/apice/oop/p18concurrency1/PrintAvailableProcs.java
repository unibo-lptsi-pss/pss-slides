package it.unibo.apice.oop.p18concurrency1;

public class PrintAvailableProcs {
	public static void main(String[] args) {
		int nprocs = Runtime.getRuntime().availableProcessors();
		System.out.println("Available processors: "+nprocs);
	}
}
