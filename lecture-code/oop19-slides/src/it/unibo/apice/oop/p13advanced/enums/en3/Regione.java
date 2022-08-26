package it.unibo.apice.oop.p13advanced.enums.en3;

import static it.unibo.apice.oop.p13advanced.enums.en3.Zona.*;

public enum Regione {
	ABRUZZO(CENTRO,"Abruzzo"), 
	BASILICATA(SUD,"Basilicata"), 
	CALABRIA(SUD,"Calabria"), 
	CAMPANIA(SUD,"Campania"), 
	EMILIA_ROMAGNA(NORD, "Emilia Romagna"), 
	FRIULI_VENEZIA_GIULIA(NORD, "Friuli Venezia Giula"), 
	LAZIO(CENTRO, "Lazio"), 
	LIGURIA(NORD, "Liguria"), 
	LOMBARDIA(NORD, "Lombardia"), 
	MARCHE(CENTRO, "Marche"),
	MOLISE(SUD, "Molise"), 
	PIEMONTE(NORD, "Piemonte"), 
	PUGLIA(SUD, "Puglia"), 
	SARDEGNA(SUD, "Sardegna"), 
	SICILIA(SUD, "Sicilia"), 
	TOSCANA(CENTRO, "Toscana"),
	TRENTINO_ALTO_ADIGE(NORD, "Trentino Alto Adige"), 
	UMBRIA(CENTRO, "Umbria"), 
	VALLE_D_AOSTA(NORD,"Valle D'Aosta"),
	VENETO(NORD,"Veneto");
	
	private final Zona z;
	private final String actualName;
	
	private Regione(final Zona z, final String actualName){
		this.z = z;
		this.actualName = actualName;
	}
	
	public Zona getZona(){
		return this.z;
	}
	
	public String toString(){
		return this.actualName;
	}
}
