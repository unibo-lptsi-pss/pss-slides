package it.unibo.apice.oop.p04objects;

class Persona2 { // dichiarazione classe
	static int currentYear = new java.util.Date().getYear();
	String nome;
	int annoNascita;
	boolean sposato;
	
	Persona2(String nome, int annoNascita, boolean sposato) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = sposato;
	}

	Persona2(String nome, int annoNascita) { // richiama costruttore a 3 arg..
		this(nome,annoNascita,false);
	}
	
	Persona2(String nome) {
		this(nome,Persona2.currentYear); // richiama costruttore a 2 arg..
	}

}