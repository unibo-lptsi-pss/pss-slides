public class Persona implements Comparable<Persona> {

	final private String nome;
	final private int annoNascita;
	final private boolean sposato;

	public Persona(String nome, int annoNascita, boolean sposato) {
		this.nome = nome;
		this.annoNascita = annoNascita;
		this.sposato = sposato;
	}

	public String toString() {
		return this.nome + ":" + this.annoNascita + ":" +
				(this.sposato ? "spos" : "non-spos");
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Persona)) {
			return false;
		}
		return this.nome.equals(((Persona) o).nome) &&
				this.annoNascita == ((Persona) o).annoNascita &&
				this.sposato == ((Persona) o).sposato;
	}

	public int hashCode() {
		int value = this.sposato ? 1 : 0;
		value = value * 31 + this.annoNascita;
		value = value * 31 + this.nome.hashCode();
		return value;
	}

	public int compareTo(Persona p) {
		return (this.annoNascita != p.annoNascita)
				? this.annoNascita - p.annoNascita
				: this.nome.compareTo(p.nome);
	}
}