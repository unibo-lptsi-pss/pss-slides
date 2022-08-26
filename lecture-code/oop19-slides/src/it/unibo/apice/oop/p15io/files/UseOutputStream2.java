package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.Random;

// Due varianti: uso di java.io.File, e catch con try-with-resources
public class UseOutputStream2 {

	public static void main(String[] args) {

		try (
			final OutputStream output = 
				new FileOutputStream(new File(UseFile.FILE_NAME));
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
		} catch (final IOException e){
			System.out.println("Something went wrong!");
		}
	}
}
