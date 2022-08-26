package it.unibo.apice.oop.p10collections.set;

import java.util.*;

public class UseHashSetPersona{
    public static void main(String[] s){
    	// HashSet è un dettaglio, lavorare sempre su Set!
    	final Set<Persona> set = new HashSet<>();
    	
    	// Agggiungo 4 elementi
    	set.add(new Persona("Rossi",1960,false));
    	set.add(new Persona("Bianchi",1980,true));
    	set.add(new Persona("Verdi",1972,false));
    	set.add(new Persona("Neri",1968,false));
    	System.out.println(set);
    	
    	// Testo presenza/assenza di 2 elementi
    	final Persona p1 = new Persona("Rossi",1960,false);
    	final Persona p2 = new Persona("Rossi",1961,false);
    	System.out.println("Cerco "+p1+" esito "+set.contains(p1));
    	System.out.println("Cerco "+p2+" esito "+set.contains(p2));
    	
    	// Iterazione: nota, fuori ordine rispetto all'inserimento
    	for (final Persona p: set){
    	    System.out.println("Itero: "+p+" hash = "+p.hashCode());
    	}
    }
} 
