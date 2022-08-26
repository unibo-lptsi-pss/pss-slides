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

