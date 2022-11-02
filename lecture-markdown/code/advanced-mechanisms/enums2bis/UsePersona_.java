package enums2bis;

import java.util.*;

public class UsePersona {
	public static void main(String[] args){
		ArrayList<Persona> list = new ArrayList<>();
		list.add(new Persona("Gino","Bianchi",Persona.Regione.SICILIA));
		list.add(new Persona("Carlo","Verdi",Persona.Regione.LOMBARDIA));
		System.out.println(list);
	}
}
