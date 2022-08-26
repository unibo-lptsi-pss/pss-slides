package it.unibo.apice.oop.p15io.files;

import java.io.*;

// Soluzione con specifica della codifica dei caratteri
public class UseStreamReadersWriters {

	public static void main(String[] args) throws Exception{

		try(final BufferedWriter w = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(UseReadersWriters.FILE_NAME),"UTF-16"))){
			w.write("Prova");
			w.newLine();
			w.write("di file");
			w.newLine();
		}
		
		try(final BufferedReader r = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(UseReadersWriters.FILE_NAME),"UTF-16"))){
			System.out.println(r.readLine());
			System.out.println(r.readLine());
			System.out.println(r.readLine()); // null
		}	
	}
}
