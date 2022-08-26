import java.util.*;

public class UseTreeSetPersona{
    public static void main(String[] s){
    	// TreeSet è un dettaglio, lavorare sempre sull'interfaccia
    	NavigableSet<Persona> set = new TreeSet<>();
    	set.add(new Persona("Rossi",1960,false));
    	set.add(new Persona("Bianchi",1980,true));
    	set.add(new Persona("Verdi",1972,false));
    	set.add(new Persona("Neri",1972,false));
    	set.add(new Persona("Neri",1968,false));
    	
    	// Iterazione in ordine, poi al contrario, poi fino al 1970
    	for (Persona p: set){
    	    System.out.println("Itero: "+p+" hash = "+p.hashCode());
    	}
    	for (Persona p: set.descendingSet()){
    	    System.out.println("Itero al contrario: "+p);
    	}
    	Persona limit = new Persona("",1970,false);
    	for (Persona p: set.headSet(limit,false)){
    	    System.out.println("Itero fino al 1970: "+p);
    	}
    }
} 
