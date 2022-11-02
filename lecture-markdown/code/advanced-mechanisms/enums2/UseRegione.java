package enums2;
import static enums2.Regione.*; // Consente di evitare 'Regione.'
import java.util.*;


public class UseRegione {
	public static void main(String[] args) {
		ArrayList<Regione> list = new ArrayList<>();
		// 4 modi di ottenere una Regione
		list.add(Regione.LOMBARDIA);
		list.add(SARDEGNA);
		list.add(Regione.valueOf("SICILIA"));
		list.add(Regione.values()[10]);
		
		for (Regione r: list){
			System.out.println("toString "+r); // LOMBARDIA,...,MOLISE
			System.out.println("ordinale "+r.ordinal()); // 8, 13, 14, 10
			System.out.println("nome "+r.name()); // LOMBARDIA,...,MOLISE
			System.out.println("---");
		}
		
		for (Regione r: Regione.values()){
			System.out.print(r+" "); // Stampa tutte le regioni
		}

	}
}
