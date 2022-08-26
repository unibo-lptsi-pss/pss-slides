package it.unibo.apice.oop.p17streams;

import java.util.*;

public class UseTransformations2 {

	public static void main(String[] args) {
		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		
		System.out.print("\nDistinct\t :");
		li.stream().distinct()	// elimina le ripetizioni
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nSorted(down)\t :");
		li.stream().sorted((i,j)->j-i) // ordina
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nPeek(.)\t\t :");
		li.stream().peek(i->System.out.print(".")) // esegue una azione per ognuno
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nLimit(5)\t :");
		li.stream().limit(5)  // solo i primi 5
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nSkip(5)\t\t :");
		li.stream().skip(5)   // salta i primi 5
		  .forEach(i->System.out.print(" "+i));
	}
}
