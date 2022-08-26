package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class UseTryWithResources {

	public static void main(String[] args) throws IOException {
		final byte[] b = new byte[] { 10, 20, 30, 40, 50 };
		int c;
		try (final InputStream in = new ByteArrayInputStream(b)) {
			while ((c = in.read()) != -1) { // C-style
				System.out.println(c);
			}
		}
	}
}
