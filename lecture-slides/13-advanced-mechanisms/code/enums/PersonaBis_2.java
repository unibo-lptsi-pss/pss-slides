	public String toString() {
		return "[" + nome + "," + cognome + ","	+ nomeRegione(regione) + "]";
	}

	public boolean isIsolano(){
		// Confronto veloce!!
		return (this.regione == SARDEGNA || 
		        this.regione == SICILIA);
	}

	public static List<Persona> fromRegione(Collection<Persona> coll, 
	                           String regione){
		ArrayList<Persona> list = new ArrayList<>();
		for (Persona persona: coll){
		    // Confronto veloce!!
			if (persona.regione == regione){
				list.add(persona);
			}
		}
		return list;
	}
}
