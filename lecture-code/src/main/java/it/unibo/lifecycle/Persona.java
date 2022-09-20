package it.unibo.lifecycle;

class Persona { // dichiarazione classe
	static int currentYear = new java.util.Date().getYear();
	String nome;
	int annoNascita;
	boolean sposato;

	Persona(String nome) {
		this.nome = nome;
		this.annoNascita = Persona.currentYear;
		this.sposato = false;
	}

	Persona(String nome, int annoNascita) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = false;
	}

	Persona(String nome, int annoNascita, boolean sposato) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = sposato;
	}
}