package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class FirstComparable {

	public static void main(String[] args) {
		
		final List<Persona> list = new ArrayList<Persona>();
		list.add(new Persona("Mario",1960,true));
		list.add(new Persona("Gino",1970,false));
		list.add(new Persona("Rino",1951,true));
		System.out.println(list);
		
		// Without lambdas
		Collections.sort(list, new Comparator<Persona>(){

			public int compare(Persona o1, Persona o2) {
				return o1.getAnno() - o2.getAnno();
			}
			
		});
		System.out.println(list);
		
		// With lambdas
		Collections.sort(list, (o1,o2) -> o2.getAnno() - o1.getAnno());
		System.out.println(list);
	}

}
