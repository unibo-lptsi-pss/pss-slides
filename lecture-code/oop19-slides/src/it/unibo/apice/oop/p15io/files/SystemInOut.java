package it.unibo.apice.oop.p15io.files;

import java.io.*;

public class SystemInOut {

	public static void main(String[] args) throws Exception{

		final InputStream is = System.in;
		final BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine()); // può lanciare una IOException
		
		final PrintStream ps = System.out; 
		// una sotto-classe di OutputStream, che incapsula un Writer
		ps.println("Un comando noto"); // non lancia eccezioni!
		ps.format("Altro comando noto.. %d %f %s\n", 10,20.2,"prova");
		
		// scrittura di file con PrintStream
		final PrintStream ps2 = new PrintStream(UseReadersWriters.FILE_NAME);
		ps2.println("prova");
		ps2.print(10);
		ps2.println();
		ps2.close();
	}
}
