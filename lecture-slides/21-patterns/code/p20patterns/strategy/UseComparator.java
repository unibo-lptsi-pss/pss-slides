package it.unibo.apice.oop.p18patterns.strategy;

import java.util.*;

public class UseComparator {

	public static void main(String[] args){
		List<Integer> list = Arrays.asList(200,31,142,65,35);
		System.out.println(list);
		// Creo tre strategie di comparazione diverse
		Comparator<Integer> c1 = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};		
		Comparator<Integer> c2 = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		Comparator<Integer> c3 = new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1%10 - o2%10;
			}
		};
		// Uso le tre strategie
		Collections.sort(list,c1);	System.out.println("cres: "+list);
		Collections.sort(list,c2);	System.out.println("decr: "+list);
		Collections.sort(list,c3);	System.out.println("unità: "+list);
	}
}
