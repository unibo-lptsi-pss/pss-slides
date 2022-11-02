public enum Regione {
	ABRUZZO, BASILICATA, CALABRIA, CAMPANIA, EMILIA_ROMAGNA, 
	FRIULI_VENEZIA_GIULIA, LAZIO, LIGURIA, LOMBARDIA, MARCHE, 
	MOLISE, PIEMONTE, PUGLIA, SARDEGNA, SICILIA, TOSCANA,
	TRENTINO_ALTO_ADIGE, UMBRIA, VALLE_D_AOSTA,	VENETO;
	
	boolean isIsola(){
		return this == SARDEGNA || this == SICILIA;
	}
}

public class Persona {
	private String nome;
	private String cognome;
	private Regione regione;
    ...
	public boolean isIsolano(){
		return this.regione.isIsola();
	}
	...
}
