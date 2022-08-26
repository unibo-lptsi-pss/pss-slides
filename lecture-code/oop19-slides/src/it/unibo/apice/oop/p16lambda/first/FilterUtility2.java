package it.unibo.apice.oop.p16lambda.first;

import java.util.*;
import java.util.function.Predicate;

public class FilterUtility2 {
	
	public static <X> Set<X> filterAll(Collection<X> set,Predicate<X> filter){
		final Set<X> newSet = new HashSet<>();
		for (final X x: set){
			if (filter.test(x)){
				newSet.add(x);
			}
		}
		return newSet;
	}

	public static void main(String[] args) {
		final List<Integer> ls = Arrays.asList(10,20,30,40,50,60);
		
		// Note that the name of the method in Filter is never mentioned here
		System.out.println(filterAll(ls,x -> x>20)); // [30,40,50,60]
		System.out.println(filterAll(ls,x -> x>20 && x<60)); // [30,40,50]
		System.out.println(filterAll(ls,x -> x%20==0)); // [20,40,60]
	}
}
