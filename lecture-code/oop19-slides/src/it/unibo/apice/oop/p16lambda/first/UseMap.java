package it.unibo.apice.oop.p16lambda.first;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		final Map<Integer,String> map = new HashMap<>();
		map.put(10,"a");
		map.put(20,"bb");
		map.put(30,"ccc");
		
		map.forEach((k,v) -> System.out.println(k+" "+v));
		
		map.replaceAll( (k,v) -> v+k); // nuovi valori
		System.out.println(map);
		// {20=bb20, 10=a10, 30=ccc30}
		
		map.merge(5,".", String::concat);
		map.merge(10,".", String::concat);
		System.out.println(map);
		// {20=bb20, 5=., 10=a10., 30=ccc30}
		
		System.out.println(map.getOrDefault(5, "no")); // "."
		System.out.println(map.getOrDefault(6, "no")); // "no"
	}
}
