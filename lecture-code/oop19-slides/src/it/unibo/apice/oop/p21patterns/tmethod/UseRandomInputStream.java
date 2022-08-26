package it.unibo.apice.oop.p21patterns.tmethod;

import java.io.*;
import java.util.*;

public class UseRandomInputStream {

	public static void main(String[] args) throws IOException {
		
		// Il metodo InputStream.read(byte[]) è un Template Method
		// Dipende dall'implementazione (non nota) di InputStream.read()
		
		// Creo una sottoclasse in cui concretizzo read()
		InputStream	input = new InputStream(){ // Uno stream ad-hoc
			int ct = 0;
			public int read() throws IOException {
				return ct++;
			}
		};
		
		// Ora provo InputStream.read(byte[]) e lo trovo concretizzato
		final byte[] b = new byte[100];
		input.read(b);
		System.out.println(Arrays.toString(b));
		// [0,1,2,3,4,5,6,..]
	}
}
