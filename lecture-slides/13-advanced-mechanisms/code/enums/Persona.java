package enums;

import java.util.*;

public class Persona {
	private String nome;
	private String cognome;
	private String regione;
	
	public Persona(String nome, String cognome, String regione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.regione = regione;
	}
	
	public String toString() {
		return "[" + nome + "," + cognome + ","	+ regione + "]";
	}
	
	public boolean isIsolano(){
		// Confronto lento!!
		return (this.regione.equals("Sardegna") || this.regione.equals("Sicilia"));
	}

	public static List<Persona> fromRegione(Collection<Persona> coll, String regione){
		ArrayList<Persona> list = new ArrayList<>();
		for (Persona persona: coll){
			if (persona.regione.equals(regione)){ // Confronto lento!!
				list.add(persona);
			}
		}
		return list;
	}
}
