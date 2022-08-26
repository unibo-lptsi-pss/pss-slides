public class Persona {
	
	public static enum Regione {
		ABRUZZO, BASILICATA, CALABRIA, CAMPANIA, EMILIA_ROMAGNA, 
		FRIULI_VENEZIA_GIULIA, LAZIO, LIGURIA, LOMBARDIA, MARCHE, 
		MOLISE, PIEMONTE, PUGLIA, SARDEGNA, SICILIA, TOSCANA,
		TRENTINO_ALTO_ADIGE, UMBRIA, VALLE_D_AOSTA,	VENETO;
	}
	
	private String nome;
	private String cognome;
	private Regione regione;
	
	public Persona(String nome, String cognome, Regione regione) {
		... // implementazione usuale..
	}
	
	public String toString() {
		return "[" + nome + "," + cognome + ","	+ regione + "]";
	}
	
	public boolean isIsolano(){
		// nota la qualificazione Regione.
		return (this.regione.equals(Regione.SARDEGNA) || 
		        this.regione.equals(Regione.SICILIA));
	}
}
