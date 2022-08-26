package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class RunnableUtility {
	
	private  static void iterate(final int howMany, final Runnable r){
		for (int i = 0; i < howMany; i++){
			r.run();
		}
	}
	
	private static void batchExecution(final List<Runnable> list){
		for (final Runnable r: list){
			r.run();
		}
	}

	public static void main(String[] args) {
		iterate(10,()-> System.out.println("ok"));
		final List<Runnable> list=Arrays.asList( 
				()->System.out.println("a"),
				()->System.out.println("b"),
				()->System.out.println("c"),
				()->System.exit(0)
		); // Inferenza su asList automatica!
		batchExecution(list);
	}
}
