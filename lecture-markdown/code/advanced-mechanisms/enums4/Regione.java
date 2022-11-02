package enums4;
import static enums4.Zona.*;

public enum Regione {
	ABRUZZO(CENTRO,"Abruzzo"), 
	BASILICATA(SUD,"Basilicata"), 
	CALABRIA(SUD,"Calabria"), 
	... 
	VALLE_D_AOSTA(NORD,"Valle D'Aosta"),
	VENETO(NORD,"Veneto");
	
	private Zona z;
	private String actualName;
	
	private Regione(Zona z, String actualName){
		this.z=z;
		this.actualName=actualName;
	}
	
	public Zona getZona(){
		return this.z;
	}
	
	public String toString(){
		return this.actualName;
	}
}
