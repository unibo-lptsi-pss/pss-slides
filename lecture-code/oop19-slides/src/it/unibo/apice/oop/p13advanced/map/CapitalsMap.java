package it.unibo.apice.oop.p13advanced.map;

import java.util.*;

public class CapitalsMap extends AbstractMap<String,String>{

	private static final Set<Map.Entry<String,String>> set;
	
	// inizializzatore statico.. 
	// usato per inizializzare i campi statici
	static{ 
		// costruisce il valore di set
		set = new HashSet<>();
		set.add(new AbstractMap.SimpleEntry<>("Italy","Rome"));
		set.add(new AbstractMap.SimpleEntry<>("France","Paris"));
		set.add(new AbstractMap.SimpleEntry<>("Germany","Berlin"));
	}
	
	public CapitalsMap(){}
	
	// Questo è l'unico metodo che è necessario implementare
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return set; 
	}
	
}
