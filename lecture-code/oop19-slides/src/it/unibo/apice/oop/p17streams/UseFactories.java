package it.unibo.apice.oop.p17streams;

import java.util.*;
import java.util.stream.*;

public class UseFactories {

	public static void main(String[] args) {

		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		System.out.print("Collection: ");
		li.stream()
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nEmpty: ");
		Stream.empty()
		      .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nFromValues: ");
		Stream.of("a","b","c")
		      .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nIterate(+1): ");
		Stream.iterate(0,i->i+1)  // 0,1,2,3,...
		      .limit(20)
		      .forEach(i->System.out.print(" "+i));
	}
}

