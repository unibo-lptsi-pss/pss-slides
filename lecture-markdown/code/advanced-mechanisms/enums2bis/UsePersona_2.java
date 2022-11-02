package enums2bis;

import java.util.*;
import static enum2bis.Persona.Regione.*;

public class UsePersona2 {
	public static void main(String[] args){
		ArrayList<Persona> list = new ArrayList<>();
		list.add(new Persona("Gino","Bianchi",SICILIA));
		list.add(new Persona("Carlo","Verdi",LOMBARDIA));
		System.out.println(list);
	}
}
