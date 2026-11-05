	public String toString() {
		return "[" + name + "," + surname + ","	+ regionName(region) + "]";
	}

	public boolean isIslander(){
		// Confronto veloce!!
		return (this.region == SARDEGNA || 
		        this.region == SICILIA);
	}

	public static List<Person> fromRegion(Collection<Person> coll, 
	                           String region){
		ArrayList<Person> list = new ArrayList<>();
		for (Person person: coll){
		    // Confronto veloce!!
			if (person.region == region){
				list.add(person);
			}
		}
		return list;
	}
}
