package map;

import java.util.*;

public class UseMap2 {
	public static void main(String[] args) {
		// Uso una incarnazione, ma poi lavoro sull'interfaccia
		Map<Integer, String> map = new HashMap<>();
		// Una mappa è una funzione discreta
		map.put(345211, "Bianchi");
		map.put(345122, "Rossi");
		map.put(243001, "Verdi");

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry);
			entry.setValue(null);
		}
		System.out.println(map);
		// {345211=null, 243001=null, 345122=null}
	}
}
