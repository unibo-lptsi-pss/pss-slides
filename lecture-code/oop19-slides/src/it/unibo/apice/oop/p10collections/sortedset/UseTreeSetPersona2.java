package it.unibo.apice.oop.p10collections.sortedset;

import java.util.*;

public class UseTreeSetPersona2{
    
	public static void main(String[] s){
    	
    	// TreeSet è un dettaglio, lavorare sempre sull'interfaccia
    	final Set<Persona> set = 
    			new TreeSet<>(new PersonaComparator());
    	
    	set.add(new Persona("Rossi",1960,false));
    	set.add(new Persona("Bianchi",1980,true));
    	set.add(new Persona("Verdi",1972,false));
    	set.add(new Persona("Neri",1972,false));
    	set.add(new Persona("Neri",1968,false));
    	
    	// Iterazione in ordine
    	for (final Persona p: set){
    	    System.out.println(p);
    	}
    }
} 
