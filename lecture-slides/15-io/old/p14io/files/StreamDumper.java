package it.unibo.apice.oop.p14io.files;

import java.io.*;

// StreamDumper segue il pattern Singleton
// Impone un unico oggetto usabile per questa classe

public class StreamDumper {
	
	private static StreamDumper SINGLETON = new StreamDumper();
	
	private StreamDumper(){} // Rende inaccessibile il costruttore
	
	public static StreamDumper getStreamDumper(){
		return SINGLETON;
	}
	
	public void dump(InputStream input) throws IOException{
		for (int c=0; (c = input.read()) != -1;) {
			System.out.print(c+"\t");
		}
	}
}
