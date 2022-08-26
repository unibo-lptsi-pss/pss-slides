package it.unibo.apice.oop.p14io.files;

import java.io.*;
import java.util.*;

public class ListOnFile {
	
	private static final String STR = "/home/mirko/aula/14/prova.bin";
	
	public static void main(String[] args) throws IOException{
		List<Byte> list = new ArrayList<>(); // Creo una lista random
		byte[] ar = new byte[20];
		new Random().nextBytes(ar);
		for (byte b: ar){
			list.add(b);
		}
		System.out.println("Prima: "+list);
		
		FileOutputStream file = new FileOutputStream(STR);
		for (byte b: list){					// La riverso su file
			file.write(b);
		}
		file.close();
		
		FileInputStream file2 = new FileInputStream(STR);
		List<Byte> list2 = new ArrayList<>();
		int c;
		while ( (c = file2.read())!=-1){	// Ricarico da file
			list2.add((byte)c);
		}
		file2.close();
		System.out.println("Dopo: "+list2);
	}
}
