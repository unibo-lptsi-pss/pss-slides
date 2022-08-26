package enums;

import java.util.ArrayList;
import java.util.List;

public class UsePersona {
	public static void main(String[] args){
		ArrayList<Persona> list = new ArrayList<>();
		list.add(new Persona("Mario","Rossi",Persona.EMILIA_ROMAGNA));
		list.add(new Persona("Gino","Bianchi",3));
		list.add(new Persona("Carlo","Verdi",Persona.LOMBARDIA)); 
		// Non si hanno errori sulle stringhe
		// Non si può prevenire l'uso diretto di interi..
		...
	}
}
