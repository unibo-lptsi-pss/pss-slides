package it.unibo.apice.oop.p13advanced.nested;

import java.util.*;

public class UseSortLambda {

	public static void main(String[] args) {
		final List<Integer> list = Arrays.asList(10,40,7,57,13,19,21,35);
		System.out.println(list);
		// classe anonima a partire da una interfaccia
		Collections.sort(list,(a,b)->a-b);
		System.out.println(list);

		Collections.sort(list,(a,b)->b-a);
		System.out.println(list);
	}
}






