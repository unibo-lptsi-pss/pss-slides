package it.unibo.apice.oop.p13advanced.map;

import java.util.*;

public class UseCapitalsMap{

	public static void main(String[] args){
		CapitalsMap cmap = new CapitalsMap();
		System.out.println("Capital of Italy: "+cmap.get("Italy"));
		System.out.println("Capital of Spain: "+cmap.get("Spain"));
		System.out.println("All CapitalsMap: "+cmap);
		
		// Iterazione "lenta" su una mappa
		for (final String key: cmap.keySet()){
			System.out.println("K,V: "+key+" "+cmap.get(key));
		}
		
		// Iterazione veloce su una mappa
		for (final Map.Entry<String, String> entry: cmap.entrySet()){
			System.out.println("E: "+entry+" "+entry.getKey()+" "+entry.getValue());
		}
	}
}
