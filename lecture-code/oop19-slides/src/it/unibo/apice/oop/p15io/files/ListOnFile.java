package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.*;

public class ListOnFile {

	public static void main(String[] args) throws IOException {
		final List<Byte> list = new ArrayList<>(20); // Creo una lista random
		final byte[] ar = new byte[20];
		new Random().nextBytes(ar);
		for (final byte b : ar) {
			list.add(b);
		}
		System.out.println("Prima: " + list);
		try (
			final OutputStream file = new FileOutputStream(UseFile.FILE_NAME)
		) {
			for (final byte b : list) { // La riverso su file
				file.write(b);
			}
		}
		try (
			final InputStream file2 = new FileInputStream(UseFile.FILE_NAME)
		) {
			final List<Byte> list2 = new ArrayList<>();
			int c;
			while ((c = file2.read()) != -1) { // Ricarico da file
				list2.add((byte) c);
			}
			System.out.println("Dopo: " + list2);
		}
	}
}
