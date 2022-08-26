package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class UseDataStream {

	public static void main(String[] args) throws IOException {

		try (
			final OutputStream file = new FileOutputStream(UseFile.FILE_NAME);
			final DataOutputStream dstream = new DataOutputStream(file);
		) {
			dstream.writeBoolean(true);
			dstream.writeInt(10000);
			dstream.writeUTF("Ciao");
			dstream.writeDouble(5.2);
		}
		try (
			final InputStream file2 = new FileInputStream(UseFile.FILE_NAME);
			final DataInputStream dstream2 = new DataInputStream(file2);
		){
			System.out.println(dstream2.readBoolean()); // Do not change order
			System.out.println(dstream2.readInt());
			System.out.println(dstream2.readUTF());
			System.out.println(dstream2.readDouble());
		}
	}
}
