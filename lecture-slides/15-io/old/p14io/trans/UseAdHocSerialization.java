package it.unibo.apice.oop.p14io.trans;

import java.io.*;

public class UseAdHocSerialization {

	private static final String STR = "/home/mirko/aula/14/prova.bin";

	public static void main(String[] args) throws Exception{

		ObjectOutputStream out = new ObjectOutputStream(
										new FileOutputStream(STR));
	    APersona p = new APersona("Rossi");
	    p.used();
	    System.out.println(p);
		out.writeObject(p);
		out.close();
		
		System.out.println("Ri-carico l'oggetto... ");
		
		ObjectInputStream in = new ObjectInputStream(
										new FileInputStream(STR));
		APersona q = (APersona)in.readObject();
		System.out.println(q);
		in.close();
	}
}
