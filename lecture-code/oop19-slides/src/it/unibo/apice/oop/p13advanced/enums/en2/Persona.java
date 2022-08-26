package it.unibo.apice.oop.p13advanced.enums.en2;

import java.util.*;

public class Persona {
	private final String nome;
	private final String cognome;
	private final Regione regione;
	
	public Persona(String nome, String cognome, Regione regione) {
		this.nome = nome;
		this.cognome = cognome;
		this.regione = regione;
	}
	
	public boolean isIsolano(){
		// Confronto veloce!!
		return (this.regione == Regione.SARDEGNA 
				|| this.regione == Regione.SICILIA);
	}

	public static List<Persona> fromRegione(Collection<Persona> coll, 
			Regione regione){
		final List<Persona> list = new ArrayList<>();
		for (final Persona persona: coll){
			if (persona.regione == regione){ // Nota l'== !!
				list.add(persona);
			}
		}
		return list;
	}
	
	public String toString() {
		return "[" + nome + "," + cognome + ","	+ regione + "]";
	}
}
