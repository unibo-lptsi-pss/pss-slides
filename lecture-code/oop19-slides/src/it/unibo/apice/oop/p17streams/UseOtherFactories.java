package it.unibo.apice.oop.p17streams;

import java.nio.file.*;
import java.nio.charset.*;

public class UseOtherFactories {
	
	private final static String aDir = "/home/mirko/aula";
	private final static String aFile = "/home/mirko/aula/oop/17/Counter.java";
	
	public static void main(String[] args) throws Exception {
		
		final Path dirPath = FileSystems.getDefault().getPath(aDir);
		
		System.out.println("Found below "+aDir);
		Files.find(dirPath, 2, (a,b)->true).forEach(System.out::println);
	    
		System.out.println("List directory "+aDir);
		Files.list(dirPath).forEach(System.out::println);
	    
		final Path filePath = FileSystems.getDefault().getPath(aFile);
	    
		System.out.println("Contenuto of "+aFile);
		Files.lines(filePath).forEach(System.out::println);
	    
		System.out.println("Contenuto of "+aFile+" in altra codifica");
		Files.lines(filePath,StandardCharsets.ISO_8859_1).forEach(System.out::println);
	    
		// Si veda il sorgente di BufferedReader.lines() per capire come si realizza
		// uno stream a partire da un iteratore
		
		System.out.println("Stream da una stringa..");
		"Hellò!".chars().mapToObj(i->(char)i).forEach(System.out::println);
	}
}

