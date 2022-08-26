package it.unibo.apice.oop.p18patterns.strategy;

import java.util.*;

public class Filter {
	
	public static interface Predicate<X>{
		boolean holds(X x);
	}
	// Estrae solo gli elementi che soddisfano il predicato 'pred'
	public static <X> List<X> filter(Predicate<X> pred,List<X> list){
		List<X> out = new ArrayList<>(list.size());
		for (X x: list){
			if (pred.holds(x)){ out.add(x);};
		}
		return out;
	}
	// Main di prova
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(10,20,30,40,50);
		List<Integer> l2 = filter(new Predicate<Integer>(){
			public boolean holds(Integer x) {
				return x > 20 && x < 50;
			}
		},l);
		System.out.println(l);
		System.out.println(l2);
		// Per esercizio, costruire un filtro su Persone..
	}
}
