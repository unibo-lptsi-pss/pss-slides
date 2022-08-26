package it.unibo.apice.oop.p09generics.wildcard;

import it.unibo.apice.oop.p09generics.iterators.*;

public class Wildcard{
    
	// Metodo che usa la wildcard
    public static void printAll(Iterator<?> it){
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }
    
	// Analoga versione con metodo generico    
    public static <T> void printAll2(Iterator<T> it){
    	while (it.hasNext()){
    		System.out.println(it.next());
    	}
    }
    
    // Quale versione preferibile?
    
    public static void main(String[] s){
    	Wildcard.printAll(new IntRangeIterator(1,5));
    	Wildcard.printAll2(new IntRangeIterator(1,5));
    	Wildcard.<Integer>printAll2(new IntRangeIterator(1,5));
    }
} 
