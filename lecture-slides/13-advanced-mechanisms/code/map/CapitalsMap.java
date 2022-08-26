package map;
import java.util.*;

public class CapitalsMap extends AbstractMap<String,String>{

	private final static Set<Map.Entry<String,String>> SET;
	
	static{ // costruisce il valore di SET una volta per tutte
		SET = new HashSet<>();
		SET.add(new AbstractMap.SimpleEntry<>("Italy","Rome"));
		SET.add(new AbstractMap.SimpleEntry<>("France","Paris"));
		SET.add(new AbstractMap.SimpleEntry<>("Germany","Berlin"));
	}
	
	public CapitalsMap(){}
	
	// Questo è l'unico metodo che è necessario implementare
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return SET; 
	}
	
	public static void main(String[] args){
		CapitalsMap cmap = new CapitalsMap();
		System.out.println("Capital of Italy: "+cmap.get("Italy"));//Rome
		System.out.println("Capital of Spain: "+cmap.get("Spain"));//null
		System.out.println("All CapitalsMap: "+cmap);
	}
}
