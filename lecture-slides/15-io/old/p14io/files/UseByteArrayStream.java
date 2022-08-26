package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class UseByteArrayStream {
	
	public static void main(String[] args) throws IOException{
		byte[] b = new byte[]{10,20,30,40,50};
		ByteArrayInputStream in = new ByteArrayInputStream(b);
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
