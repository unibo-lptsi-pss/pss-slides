package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class UseBufferedDataStream2 {

		public static void main(String[] args) throws IOException {
		// dstream -> bstream -> file
		try (
			final DataOutputStream dstream = new DataOutputStream(
				new BufferedOutputStream(
					new FileOutputStream(UseFile.FILE_NAME)));
		){
			dstream.writeBoolean(true);
			dstream.writeInt(10000);
			dstream.writeDouble(5.2);
			dstream.writeUTF("Prova"); // Scrive in rappresentazione UTF-16
		}
		// dstream2 -> bstream2 -> file2
		try (
			final DataInputStream dstream2 = new DataInputStream(
				new BufferedInputStream(
					new FileInputStream(UseFile.FILE_NAME)));
		){
			System.out.println(dstream2.readBoolean()); // Do not change order!!
			System.out.println(dstream2.readInt());
			System.out.println(dstream2.readDouble());
			System.out.println(dstream2.readUTF());
		}
	}
}
