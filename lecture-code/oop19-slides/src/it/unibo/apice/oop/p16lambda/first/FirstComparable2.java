package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class FirstComparable2 {

	public static void main(String[] args) {
		
		final List<Persona> list = new ArrayList<Persona>();
		list.add(new Persona("Mario",1960,true));
		list.add(new Persona("Gino",1970,false));
		list.add(new Persona("Rino",1951,true));
		System.out.println(list);
		
		// Sorting with a lambda
		Collections.sort(list, (p1,p2) -> p2.getAnno()-p1.getAnno());
		System.out.println(list);
		
		// Nota che sort richiede un Comparator<Persona>, che ha il solo metodo: 
		// 		int compare(Persona p1, Persona p2)
		// Quindi il codice equivalente generato da javac è:
		Collections.sort(list, new Comparator<Persona>(){
			public int compare(Persona p1, Persona p2) {
				return p2.getAnno()-p1.getAnno();
			}
		});
		
		System.out.println(list);
	}

}
