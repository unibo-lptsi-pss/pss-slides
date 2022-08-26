package it.unibo.apice.oop.p10collections.sortedset;

public class Persona implements Comparable<Persona> {

	private final String nome;
	private final int annoNascita;
	private final boolean sposato;

	public Persona(String nome, int annoNascita, boolean sposato) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = sposato;
	}

	public String getNome() {
		return nome;
	}

	public int getAnnoNascita() {
		return annoNascita;
	}

	public boolean isSposato() {
		return sposato;
	}

	public String toString() {
		return this.nome + ":" + this.annoNascita + ":" + (this.sposato ? "spos" : "non-spos");
	}

	public int compareTo(Persona p) {
		return (this.annoNascita != p.annoNascita) ? this.annoNascita - p.annoNascita 
				                                   : this.nome.compareTo(p.nome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoNascita;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (sposato ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		if (annoNascita != other.annoNascita) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (sposato != other.sposato) {
			return false;
		}
		return true;
	}
	
}