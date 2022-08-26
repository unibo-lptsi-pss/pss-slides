package it.unibo.apice.oop.p13advanced.enums.en;

public class Regione {
	
	public static final Regione MARCHE = new Regione(0,"Marche");
	public static final Regione VENETO = new Regione(1,"Veneto");
	public static final Regione LOMBARDIA = new Regione(2,"Lombardia");
	
	public static final Regione[] VALUES = 
			new Regione[] {MARCHE, VENETO, LOMBARDIA};
	
	private final int id;
	private final String name;
	
	private Regione(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "Regione [id=" + id + ", name=" + name + "]";
	}
}
