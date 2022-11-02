package enums2;

import java.util.*;

public class UseEnum {
	public static void main(String[] args) {
		List<Regione> list = new ArrayList<>();
		
		list.add(Regione.LOMBARDIA);
		list.add(Regione.PIEMONTE);
		list.add(Regione.LIGURIA);
		
		for (Regione r: list){
			System.out.println(r);
		}
	}
}
