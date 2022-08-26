package enums2;

import java.util.*;
import static enums2.Regione.*; 
// Lo static import consente di evitare 'Regione.' ovunque sarebbe servito

public class UsePersona {
	public static void main(String[] args){
		ArrayList<Persona> list = new ArrayList<>();
		list.add(new Persona("Mario","Rossi",EMILIA_ROMAGNA));
		list.add(new Persona("Gino","Bianchi",SICILIA));
		list.add(new Persona("Carlo","Verdi",LOMBARDIA));
		List<Persona> out = Persona.fromRegione(list,EMILIA_ROMAGNA); 
		System.out.println(list);
		// [[Mario,Rossi,EMILIA_ROMAGNA], [Gino,Bianchi,SICILIA], 
		// [Carlo,Verdi,LOMBARDIA]]
		System.out.println(out);
		// [[Mario,Rossi,EMILIA_ROMAGNA]]
		for (Persona p: list){
			if (p.isIsolano()){
				System.out.println(p);
			}
		}
		// [Gino,Bianchi,SICILIA]
	}
}
