package it.unibo.apice.oop.p10collections.sortedset;
import java.util.*;

public class UseTreeSetPersona2{
    public static void main(String[] s){
    	
    	List<Integer> l = Arrays.asList(new Integer[]{10,20,30,40});
    	// TreeSet è un dettaglio, lavorare sempre sull'interfaccia
    	NavigableSet<Persona> set = new TreeSet<>(new PersonaComparator());
    	
    	set.add(new Persona("Rossi",1960,false));
    	set.add(new Persona("Bianchi",1980,true));
    	set.add(new Persona("Verdi",1972,false));
    	set.add(new Persona("Neri",1972,false));
    	set.add(new Persona("Neri",1968,false));
    	
    	// Iterazione in ordine
    	for (Persona p: set){
    	    System.out.println(p);
    	}
    }
} 
