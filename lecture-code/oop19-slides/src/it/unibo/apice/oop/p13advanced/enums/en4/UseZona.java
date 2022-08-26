package it.unibo.apice.oop.p13advanced.enums.en4;

public class UseZona {
	public static void main(String[] args) {
		for (Regione r: Regione.Zona.NORD.getRegioni()){
			System.out.println("toString "+r); 
			// Emilia Romagna,...,Veneto
			System.out.println("nome "+r.name());
			// EMILIA_ROMAGNA,...,VENETO
			System.out.println("---");
		}
	}
}
