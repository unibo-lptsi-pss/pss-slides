public class Persona {

	private final String nome;
	private final int annoNascita;
	private final boolean sposato;

	public Persona(String nome,int annoNascita,boolean sposato){
    	... // setting dei field
    }

	public String toString(){...}

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
}