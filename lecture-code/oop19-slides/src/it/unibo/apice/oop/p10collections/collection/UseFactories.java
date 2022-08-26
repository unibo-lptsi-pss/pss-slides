package it.unibo.apice.oop.p10collections.collection;

import java.util.*;

public class UseFactories{
    public static void main(String[] s){
    	// Metodi statici di creazione per Set e List immutabili
    	
    	final Set<Integer> set = Set.of(1,2,3,4,5,6);
    	System.out.println(set);
    	
    	final List<String> list = List.of("a","b","c","a");
    	System.out.println(list);
    	
    	final Set<String> set2 = Set.copyOf(list);
    	System.out.println(set2);
    	
    	System.out.println(list.hashCode());
    }
}

