package it.unibo.apice.oop.p17streams;

import java.util.stream.*;

public class UseFactories2 {

	public static void main(String[] args) {

		System.out.print("\nSuppl(random): ");
		Stream.generate(()->Math.random()) // rand,rand,rand,...
		      .limit(5)
		      .forEach(i->System.out.print(" "+i));
		//DoubleStream.generate(()->Math.random())... stream unboxed
		
		System.out.print("\nConcat: ");
		Stream.concat(Stream.of("a","b"),Stream.of(1,2))
		      .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nBuilder: ");
		Stream.builder()
		      .add(1)
		      .add(2)
		      .build()
		      .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nRange: ");
		IntStream.range(0,20) // 0,1,..,19
		         .forEach(i->System.out.print(" "+i));
	}
}

