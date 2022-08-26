package enums4;
import static enums4.Zona.*; // Consente di evitare 'Regione.'


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
