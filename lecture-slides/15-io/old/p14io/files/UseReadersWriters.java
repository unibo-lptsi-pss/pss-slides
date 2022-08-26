package it.unibo.apice.oop.p14io.files;

import java.io.*;

public class UseReadersWriters {

	private static final String STR = "/home/mirko/aula/14/prova.txt";

	public static void main(String[] args) throws Exception{

		FileWriter file = new FileWriter(STR);
		BufferedWriter w = new BufferedWriter(file);
		
		w.write("Prova");
		w.newLine();
		w.write("di file");
		w.newLine();
		w.close();
		
		FileReader file2 = new FileReader(STR);
		BufferedReader r = new BufferedReader(file2);
		
		System.out.println(r.readLine());
		System.out.println(r.readLine());
		System.out.println(r.readLine()); // null
		r.close();	
	}
}
