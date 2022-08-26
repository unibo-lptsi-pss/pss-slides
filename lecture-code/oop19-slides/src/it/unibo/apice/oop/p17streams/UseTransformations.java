package it.unibo.apice.oop.p17streams;

import java.util.*;

public class UseTransformations {

	public static void main(String[] args) {
		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		
		System.out.print("All\t\t :");
		li.stream()
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nFilter(>10)\t :");
		li.stream()
		  .filter(i->i>10) // fa passare solo certi elementi
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nMap(N:i+1)\t :");
		li.stream()			
		  .map(i->"N:"+(i+1)) // trasforma ogni elemento
		  .forEach(i->System.out.print(" "+i));
		
		System.out.print("\nflatMap(i,i+1)\t :");
		li.stream()
		  .flatMap(i->List.of(i,i+1).stream()) // trasforma e appiattisce
		  .map(String::valueOf) // invece del forEach.. 
		  .map(" "::concat)
		  .forEach(System.out::print);
	}

}
