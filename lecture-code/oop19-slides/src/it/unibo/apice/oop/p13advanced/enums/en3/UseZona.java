package it.unibo.apice.oop.p13advanced.enums.en3;

import static it.unibo.apice.oop.p13advanced.enums.en3.Zona.*; 

public class UseZona {
	public static void main(String[] args) {
		for (Regione r: NORD.getRegioni()){
			System.out.println("toString "+r); 
			// Emilia Romagna,...,Veneto
			System.out.println("nome "+r.name());
			// EMILIA_ROMAGNA,...,VENETO
			System.out.println("---");
		}
	}
}
