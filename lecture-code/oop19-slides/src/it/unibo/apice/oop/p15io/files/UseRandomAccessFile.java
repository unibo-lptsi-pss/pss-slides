package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class UseRandomAccessFile {

	public static void main(String[] args) throws IOException {

		try (final RandomAccessFile raf = new RandomAccessFile(
				UseFile.FILE_NAME, "rw")) { // read-write

			for (int i = 0; i < 100000; i++) {
				System.out.println("writing: " + i);
				raf.writeInt(i);
			}
			raf.seek(23000 * 4);
			System.out.println("reading in position 23000*4: " + raf.readInt());
			raf.setLength(800000);
			System.out.println("extending the size");
			raf.seek(123000 * 4);
			System.out.println("reading in position 123000*4: " + raf.readInt());
		}
	}

}
