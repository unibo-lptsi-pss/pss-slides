package it.unibo.apice.oop.p15io.trans;

import java.io.*;

import it.unibo.apice.oop.p15io.files.UseFile;

public class UseTransient {

	public static void main(String[] args) throws Exception {

		try (final ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(UseFile.FILE_NAME))){
			final CPersona p = new CPersona("Rossi", 1960, false);
			System.out.println("Prima stampa " + p); // cache vuota
			System.out.println("Seconda stampa " + p); // cache non vuota
			out.writeObject(new CPersona("Rossi", 1960, false));
		}

		System.out.println("Ri-carico l'oggetto... ");

		try (final ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(UseFile.FILE_NAME))){
			final CPersona q = (CPersona) in.readObject(); //attenzione al cast!
			System.out.println("Prima stampa " + q); // cache vuota
			System.out.println("Seconda stampa " + q); // cache non vuota
		}
	}
}
