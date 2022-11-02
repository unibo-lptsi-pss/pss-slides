	public boolean isIsolano(){
		// Confronto lento!!
		return (this.regione.equals("Sardegna") || 
		        this.regione.equals("Sicilia"));
	}

	public static List<Persona> 
	        fromRegione(Collection<Persona> coll,String regione){
		ArrayList<Persona> list = new ArrayList<>();
		for (Persona persona: coll){
		    // Confronto lento!!
			if (persona.regione.equals(regione)){
				list.add(persona);
			}
		}
		return list;
	}
}
