package it.unibo.apice.oop.p10collections.sortedset;

import java.util.Comparator;

/* Implementa la politica di confronto esternamente a Persona */

public class PersonaComparator implements Comparator<Persona> {

	// Confronto prima sul nome, poi sull'anno
	public int compare(Persona o1, Persona o2) {
		return o1.getNome().equals(o2.getNome()) 
				? o1.getAnnoNascita() - o2.getAnnoNascita()
				: o1.getNome().compareTo(o2.getNome());
	}
	
	
}