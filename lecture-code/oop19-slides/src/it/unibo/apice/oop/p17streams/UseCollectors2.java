package it.unibo.apice.oop.p17streams;

import java.util.*;
import static java.util.stream.Collectors.*;

public class UseCollectors2 {

	public static void main(String[] args) {

		final List<Integer> li = List.of(10,20,30,5,6,7,10,20,100);
		
		final Map<Integer,List<Integer>> map = li.stream()
				                                 .collect(groupingBy(x -> x/10));
		System.out.println(map); // {0=[5,6,7], 1=[10,10], ..}
		
		final Map<Boolean,Optional<Integer>> map2 = li.stream()
							.collect(groupingBy(x->x%2==0,minBy(Integer::compare)));
		System.out.println(map2); // minimo dei pari e minimo dei dispari
		
		final Map<Integer,Integer> map3 = li.stream()
				                            .distinct()
				                            .collect(toMap(x->x,x->x+1));
		System.out.println(map3); // mappa ogni x in x+1
		
		final Map<Integer,Integer> map4 = li.stream().collect(toMap(x->x/10,x->x,(x,y)->x+y));
		System.out.println(map4); // somma degli elementi in ogni decina
		
		System.out.println(li.stream().collect(summarizingInt(Number::intValue)).toString());
		
	}
}

