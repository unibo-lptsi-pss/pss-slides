package it.unibo.apice.oop.p10collections.sortedset;

import java.util.Comparator;

/* Implementa la politica di confronto esternamente a Persona */

public class PersonaComparator implements Comparator<Persona> {

	// confronto (lento) sulla base del toString

	public int compare(Persona o1, Persona o2) {
		return o1.toString().compareTo(o2.toString());
	}
}