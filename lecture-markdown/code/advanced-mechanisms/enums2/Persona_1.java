public class Persona {
	private String nome;
	private String cognome;
	private Regione regione;
	
	public Persona(String nome, String cognome, Regione regione) {
	    ... // al solito
	}
	public String toString() { // Nota il toString() di Regione!
		return "[" + nome + "," + cognome + ","	+ regione + "]";
	}
	
	public boolean isIsolano(){
		return (regione.equals(Regione.SARDEGNA) || 
		        regione.equals(Regione.SICILIA));
	}

	public static List<Persona> fromRegione(Collection<Persona> coll, 
	                                        Regione regione){
		ArrayList<Persona> list = new ArrayList<>();
		for (Persona persona: coll){
			if (persona.regione == regione){
				list.add(persona);
			}
		}
		return list;
	}
}
