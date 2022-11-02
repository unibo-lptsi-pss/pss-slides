package enums2;

import java.util.*;
import static enums2.Regione.*; // Consente di evitare 'Regione.'

public class Persona {
	private String nome;
	private String cognome;
	private Regione regione;
	
	public Persona(String nome, String cognome, Regione regione) {
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
		return (this.regione.equals(SARDEGNA) || this.regione.equals(SICILIA));
	}

	public static List<Persona> fromRegione(Collection<Persona> coll, Regione regione){
		ArrayList<Persona> list = new ArrayList<>();
		for (Persona persona: coll){
			if (persona.regione ==  regione){
				list.add(persona);
			}
		}
		return list;
	}
}
