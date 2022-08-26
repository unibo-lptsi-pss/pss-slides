package it.unibo.apice.oop.p10collections.collection;
import java.util.*;

public class UseListIterator{
    public static void main(String[] s){
    	// Uso una incarnazione, ma poi lavoro sul List
    	final List<Integer> list = new ArrayList<>();  	
    	list.addAll(Arrays.asList(1,3,5,7,9,11)); // var-args
    	
    	final ListIterator<Integer> it = list.listIterator();
    	while (it.hasNext()){
    	    it.add(it.next()+1);
    	}
    	System.out.println(list); // [1, 2, 3, ..., 10, 11,12]
    	while (it.hasPrevious()){
    	    System.out.println("back: "+it.previous()); // 12 .. 1
    	}
    	for (final int i: list.subList(3,10)){
    	    System.out.println("forth - 3 to 10: "+i); // 4 .. 10
    	}
    }
}

