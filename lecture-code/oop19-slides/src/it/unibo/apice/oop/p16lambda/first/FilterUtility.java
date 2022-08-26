package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class FilterUtility {
	
	public static <X> Set<X> filterAll(Collection<X> set, Filter<X> filter){
		final Set<X> newSet = new HashSet<>();
		for (final X x: set){
			if (filter.applyFilter(x)){
				newSet.add(x);
			}
		}
		return newSet;
	}

	public static void main(String[] args) {
		final List<Integer> ls = Arrays.asList(10,20,30,40,50,60);
		
		// Nota che il nome del metodo in Filter non è mai menzionato qui
		System.out.println(filterAll(ls,x -> x>20)); // [30,40,50,60]
		System.out.println(filterAll(ls,x -> x>20 && x<60)); // [30,40,50]
		System.out.println(filterAll(ls,x -> x%20==0)); // [20,40,60]
	}
}
