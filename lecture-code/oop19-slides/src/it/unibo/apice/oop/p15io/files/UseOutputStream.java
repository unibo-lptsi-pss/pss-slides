package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.Random;

public class UseOutputStream {

	public static void main(String[] args) throws IOException {

		try (
			final OutputStream output = new FileOutputStream(UseFile.FILE_NAME);
		) {
			// Aggiungo byte random
			final Random r = new Random();
			for (int i = 0; i < 100; i++) {
				output.write(r.nextInt(256));
			}

			// Aggiungo un array di byte
			final byte[] b = new byte[] { 10, 20, 30, 40 };
			for (int i = 0; i < 10; i++) {
				output.write(b);
			}
		}
	}

}
