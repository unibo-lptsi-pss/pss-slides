package enums2;
import static enums2.Regione.*; // Consente di evitare 'Regione.'
import java.util.*;


public class UseRegione2 {
	public static void main(String[] args) {
		ArrayList<Regione> list = new ArrayList<>();
		// 4 modi di ottenere una Regione
		list.add(Regione.LOMBARDIA);
		list.add(SARDEGNA);
		list.add(Regione.valueOf("SICILIA"));
		list.add(Regione.values()[10]);
		
		// Le enum sono usabili negli switch
		for (Regione r: list){
			switch (r){
			case LOMBARDIA: System.out.println("Lombardia");
							break;
			case EMILIA_ROMAGNA: System.out.println("Emilia Romagna");
							break;
			default: System.out.println("Altre..");	
				
			}
		}
	}
}
