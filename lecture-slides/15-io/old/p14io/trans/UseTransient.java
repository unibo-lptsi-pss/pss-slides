package it.unibo.apice.oop.p14io.trans;

import java.io.*;

public class UseTransient {

	private static final String STR = "/home/mirko/aula/14/prova.bin";

	public static void main(String[] args) throws Exception{

		ObjectOutputStream out = new ObjectOutputStream(
										new FileOutputStream(STR));
	    CPersona p = new CPersona("Rossi", 1960, false);
	    System.out.println("Prima stampa "+p); // cache vuota
	    System.out.println("Seconda stampa "+p); // cache non vuota
		out.writeObject(new CPersona("Rossi", 1960, false));
		out.close();
		
		System.out.println("Ri-carico l'oggetto... ");
		
		ObjectInputStream in = new ObjectInputStream(
										new FileInputStream(STR));
		CPersona q = (CPersona)in.readObject();
		System.out.println("Prima stampa "+q); // cache vuota
	    System.out.println("Seconda stampa "+q); // cache non vuota
		in.close();
	}
}
