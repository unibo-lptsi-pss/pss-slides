package it.unibo.apice.oop.p17streams;

import java.util.*;
import static java.util.stream.Collectors.*;

public class UseCollectors {

	public static void main(String[] args) {

		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		
		// una List
		System.out.println(li.stream().collect(toList()));
		// un Set
		System.out.println(li.stream().collect(toSet())); 
		// un TreeSet
		System.out.println(li.stream().collect(toCollection(TreeSet::new)));
		
		System.out.println(li.stream().collect(minBy(Integer::compare)));
		
		System.out.println(li.stream().collect(summingInt(Number::intValue)).toString());
		
		System.out.println(li.stream().map(i->i.toString())
		                              .collect(joining(",","(",")")));
		// (10,20,30,5,6,7,10,20,100)
		
	}
}

