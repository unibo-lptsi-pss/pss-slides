package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class UseDataStream {

	private static final String STR = "/home/mirko/aula/14/prova.bin";

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(STR);
		DataOutputStream dstream = new DataOutputStream(file);
		dstream.writeBoolean(true);
		dstream.writeInt(10000);
		dstream.writeDouble(5.2);
		dstream.close();

		FileInputStream file2 = new FileInputStream(STR);
		DataInputStream dstream2 = new DataInputStream(file2);
		System.out.println(dstream2.readInt());
		System.out.println(dstream2.readBoolean());
		System.out.println(dstream2.readDouble());
		dstream2.close();
	}

}
