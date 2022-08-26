package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class UseByteArrayStream {

	public static void main(String[] args) throws IOException {
		final byte[] b = new byte[] { 10, 20, -1, 40, -58 };
		final InputStream in = new ByteArrayInputStream(b);
		int c;
		try {
			while ((c = in.read()) != -1) { // C-style
				System.out.println(c);
			}
		} finally { // assicura la chiusura anche con eccezioni
			in.close();
		}
	}
}
