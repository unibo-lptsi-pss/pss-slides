package it.unibo.apice.oop.p11gencoll2.list;

import java.util.*;

public class UseArrayList{
    
	public static void main(String[] s){
    
		final ArrayList<Persona> alist = new ArrayList<>();
    	alist.ensureCapacity(30); // per performance
    	for (int anno=1960;anno<1970;anno++){
    	    alist.add(new Persona("Rossi",anno,false));
    	    alist.add(new Persona("Bianchi",anno,true));
    	    alist.add(new Persona("Verdi",anno,false));
    	}
    	final Persona p = new Persona("Rossi",1967,false);
    	int pos = alist.indexOf(p);
    	System.out.println(p+" in position "+pos);
    	
    	// Iteratore da pos fino in fondo.. lo uso per eliminare
    	final ListIterator<Persona> iterator = alist.listIterator(pos);
    	while (iterator.hasNext()){
    	    iterator.next();
    	    iterator.remove();
    	}
    	for (final Persona p2: alist){
    	    System.out.println(alist.indexOf(p2)+"\t"+p2);
    	}
    	alist.trimToSize(); // riduco le dimensioni
    }
} 

