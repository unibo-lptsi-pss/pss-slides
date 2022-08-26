package it.unibo.apice.oop.p15io.files;

public class Persona implements java.io.Serializable {

	private static final long serialVersionUID = 567742502623265945L;
	private final String nome;
	private final int annoNascita;
	private final boolean sposato;

	public Persona(
			final String nome, 
			final int annoNascita, 
			final boolean sposato
	) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = sposato;
	}

	public String toString() {
		return this.nome + ":" + this.annoNascita + ":"
				+ (this.sposato ? "spos" : "non-spos");
	}
}