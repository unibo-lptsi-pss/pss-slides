package enums;

import java.util.ArrayList;
import java.util.List;

public class UsePersona {
	public static void main(String[] args){
		ArrayList<Persona> list = new ArrayList<>();
		list.add(new Persona("Mario","Rossi","Emilia-Romagna"));
		list.add(new Persona("Gino","Bianchi","Sicilia"));
		list.add(new Persona("Carlo","Verdi","EmiliaRomagna")); 
		// Errore sul nome non intercettabile
		List<Persona> out = Persona.fromRegione(list,"Emilia-Romagna");
		System.out.println(list);
		// [[Mario,Rossi,Emilia-Romagna], [Gino,Bianchi,Sicilia], 
		//    [Carlo,Verdi,EmiliaRomagna]]
		System.out.println(out);
		// [[Mario,Rossi,Emilia-Romagna]]
		for (Persona p: list){
			if (p.isIsolano()){
				System.out.println(p);
			}
		}
		// [Gino,Bianchi,Sicilia]
	}
}
