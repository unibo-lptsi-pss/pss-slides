package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class UseBufferedDataStream {

	private static final String STR = "/home/mirko/aula/14/prova.bin";

	public static void main(String[] args) throws IOException {

	    // dstream -> bstream -> file
		FileOutputStream file = new FileOutputStream(STR);
		BufferedOutputStream bstream = new BufferedOutputStream(file);
		DataOutputStream dstream = new DataOutputStream(bstream);
		dstream.writeBoolean(true);
		dstream.writeInt(10000);
		dstream.writeDouble(5.2);
		dstream.writeUTF("Prova"); // Scrive in rappresentazione UTF-16
		dstream.close();

		// dstream2 -> bstream2 -> file2
		FileInputStream file2 = new FileInputStream(STR);
		BufferedInputStream bstream2 = new BufferedInputStream(file2);
		DataInputStream dstream2 = new DataInputStream(bstream2);
		System.out.println(dstream2.readBoolean()); // Do not change order!!
		System.out.println(dstream2.readInt());
		System.out.println(dstream2.readDouble());
		System.out.println(dstream2.readUTF());
		dstream2.close();
	}

}
