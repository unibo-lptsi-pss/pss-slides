package it.unibo.apice.oop.p13advanced.enums.en;

import java.util.*;

public class Persona {
	private final String nome;
	private final String cognome;
	private final String regione;

	public Persona(String nome, String cognome, String regione) {
		this.nome = nome;
		this.cognome = cognome;
		this.regione = regione;
	}

	public String toString() {
		return "[" + nome + "," + cognome + "," + regione + "]";
	}

	public boolean isIsolano() { // Confronto molto lento!!
		return (this.regione.equals("Sardegna") || 
				this.regione.equals("Sicilia"));
	}

	public static List<Persona> fromRegione(
			final Collection<Persona> coll, 
			final String regione
	) { // nota questa possibile formattazione 
		final List<Persona> list = new ArrayList<>();
		for (final Persona persona : coll) {
			if (persona.regione.equals(regione)) { // Confronto lento!!
				list.add(persona);
			}
		}
		return list;
	}
}
