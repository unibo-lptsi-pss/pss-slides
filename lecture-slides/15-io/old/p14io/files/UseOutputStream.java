package it.unibo.apice.oop.p14io.files;

import java.io.*;
import java.util.Random;

public class UseOutputStream {
	
	private static final String STR = "/home/mirko/aula/14/prova.txt";

	public static void main(String[] args) throws IOException {
		// Apro il file in scrittura10,20,30,40
		FileOutputStream output = new FileOutputStream(STR);
		
		// Aggiungo byte random
		Random r = new Random();
		for (int i=0; i<100; i++){
			output.write(r.nextInt(256));
		}
		
		// Aggiungo array di byte
		byte[] b = new byte[]{10,20,30,40};
		for (int i=0; i<10; i++){
			output.write(b);
		}
		
		// Chiudo il file (se non c'è stata eccezione..)
		output.close();
	}

}
