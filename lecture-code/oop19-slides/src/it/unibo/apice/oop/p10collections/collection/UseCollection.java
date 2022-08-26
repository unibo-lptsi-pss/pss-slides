package it.unibo.apice.oop.p10collections.collection;

import java.util.*;

public class UseCollection{
    public static void main(String[] s){
    	// Uso una incarnazione, ma poi lavoro sull'interfaccia
    	final Collection<Integer> coll = new ArrayList<>();  	
    	coll.addAll(Arrays.asList(1,3,5,7,9,11)); // var-args
    	System.out.println(coll); // [1, 3, 5, 7, 9, 11]
    	
    	coll.add(13);
    	coll.add(15);
    	coll.add(15);
    	coll.remove(7);
    	System.out.println(coll); // [1, 3, 5, 9, 11, 13, 15, 15]
    	
    	coll.removeAll(Arrays.asList(11,13,15));
    	coll.retainAll(Arrays.asList(1,2,3,4,5));
    	System.out.println(coll); // [1, 3, 5]
    	System.out.println(coll.contains(3)); // true
    	System.out.println(Arrays.toString(coll.toArray()));
    	
    	Integer[] a = new Integer[2];
    	a = coll.toArray(a);
    	System.out.println(Arrays.deepToString(a));
    }
}

