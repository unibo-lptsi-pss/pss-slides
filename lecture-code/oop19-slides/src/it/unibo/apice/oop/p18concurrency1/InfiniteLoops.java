package it.unibo.apice.oop.p18concurrency1;

public class InfiniteLoops {
	public static void main(String[] args){
		for (int i = 0; i < Integer.parseInt(args[0]); i++){
			System.out.println("Spawning #"+i+"...");
			new Thread(() -> { while (true){} } ).start();
		}
	}
}
