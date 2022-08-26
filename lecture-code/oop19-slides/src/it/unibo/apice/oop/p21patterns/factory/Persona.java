package it.unibo.apice.oop.p21patterns.factory;

public class Persona {
	
	private String nome;
	private String cognome;
	
	private Persona(){}
	
	public static Persona createPersona(String nome,String cognome){
		final Persona p = new Persona(); // in futuro: new SpecificPersona()..
		p.nome = nome;
		p.cognome = cognome;
		return p;
	}
	

	public static void main(String[] args) {
		final Persona p = Persona.createPersona("mario", "rossi");

	}

}
