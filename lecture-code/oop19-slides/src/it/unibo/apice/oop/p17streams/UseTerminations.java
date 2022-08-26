package it.unibo.apice.oop.p17streams;

import java.util.*;

public class UseTerminations {

	public static void main(String[] args) {

		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		System.out.print("ForEach:\t ");
		li.stream().forEach(i->System.out.print(" "+i));
		
		System.out.print("\nForEachOrdered: ");
		li.stream().forEachOrdered(i->System.out.print(" "+i));
		
		final Integer[] array = li.stream().toArray(i->new Integer[i]);
		System.out.println("\nToArray:\t "+Arrays.toString(array));
		
		//Integer sum = li.stream().reduce(0,(x,y)->x+y);
		final Integer sum = li.stream().reduce(0,Integer::sum);
		System.out.println("Sum:\t\t "+sum);
		
		//Optional<Integer> max = li.stream().max((x,y)->x-y);
		final Optional<Integer> max = li.stream().max(Integer::compare);
		System.out.println("Max:\t\t "+max);
				
		final long count = li.stream().count();
		System.out.println("Count:\t\t "+count);
		
		final boolean anyMatch = li.stream().anyMatch(x -> x==100);
		System.out.println("AnyMatch:\t "+anyMatch);
		
		final Optional<Integer> findAny = li.stream().findAny();
		System.out.println("FindAny:\t "+findAny);
	}
}

