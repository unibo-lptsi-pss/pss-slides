package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class UseObjectStream {

	private static final String STR = "/home/mirko/aula/14/prova.bin";

	public static void main(String[] args) throws Exception{

	    // ostream -> bstream -> file
		FileOutputStream file = new FileOutputStream(STR);
		BufferedOutputStream bstream = new BufferedOutputStream(file);
		ObjectOutputStream ostream = new ObjectOutputStream(bstream);
		ostream.writeInt(10000);
		ostream.writeDouble(5.2);
		ostream.writeObject(new java.util.Date()); // Classe serializ.
		ostream.writeObject(new Persona("Rossi", 1960, false));
		ostream.close();

		// ostream2 -> bstream2 -> file2
		FileInputStream file2 = new FileInputStream(STR);
		BufferedInputStream bstream2 = new BufferedInputStream(file2);
		ObjectInputStream ostream2 = new ObjectInputStream(bstream2);
		System.out.println(ostream2.readInt());
		System.out.println(ostream2.readDouble());
		System.out.println(ostream2.readObject()); // carica il Date
		System.out.println(ostream2.readObject()); // carica la Persona
		ostream2.close();
	}

}
