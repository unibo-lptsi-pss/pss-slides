package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class StreamDumper {
	
	// rendo inaccessibile il costruttore
	private StreamDumper() {}
	
	public static void dump(InputStream input) throws IOException{
		for (int c=0; (c = input.read()) != -1;) {
			System.out.print(c+"\t");
		}
	}
}
