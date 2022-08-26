package it.unibo.apice.oop.p11gencoll2.map;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		// Uso una incarnazione, ma poi lavoro sull'interfaccia
		final Map<Integer, String> map = new HashMap<>();
		// Una mappa è una funzione discreta
		map.put(345211, "Bianchi");
		map.put(345122, "Rossi");
		map.put(243001, "Verdi");
		System.out.println(map); // {345211=Bianchi, 243001=Verdi, 345122=Rossi}
		map.put(243001, "Neri"); // Rimpiazza Verdi

		// modo poco prestante per accedere alle coppie chiave-valore 
		for (final Integer i : map.keySet()) {
			System.out.println("Chiave: " + i + " Valore: " + map.get(i));
		}
		// modo prestante per accedere ai soli valori
		for (final String s : map.values()) { 
			System.out.println("Valore: " + s);
		}
	}
}
