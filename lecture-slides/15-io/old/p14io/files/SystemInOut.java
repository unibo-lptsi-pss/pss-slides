package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class SystemInOut {

	public static void main(String[] args) throws Exception{

		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine()); // può lanciare una IOException
		
		PrintStream ps = System.out; 
		// una sotto-classe di OutputStream, che incapsula un Writer
		ps.println("Un comando noto"); // non lancia eccezioni!
		ps.format("Altro comando noto.. %d %f %s\n", 10,20.2,"prova");
	}
}
