package it.unibo.apice.oop.p15io.trans;

import java.io.*;

import it.unibo.apice.oop.p15io.files.UseFile;

public class UseAdHocSerialization {

	public static void main(String[] args) throws Exception {

		try (final ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(UseFile.FILE_NAME))){
			final APersona p = new APersona("Rossi");
			p.used();
			System.out.println(p);
			out.writeObject(p);
		}
		
		System.out.println("Ri-carico l'oggetto... ");

		try (final ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(UseFile.FILE_NAME))){
			final APersona q = (APersona) in.readObject();
			System.out.println(q);
		}
	}
}
