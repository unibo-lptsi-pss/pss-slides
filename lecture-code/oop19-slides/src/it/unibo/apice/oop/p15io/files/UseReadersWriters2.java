package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.*;

public class UseReadersWriters2 {

	public static void main(String[] args) throws Exception{

		FileReader file2 = new FileReader(UseReadersWriters.FILE_NAME);
		BufferedReader r = new BufferedReader(file2);
		
		List<String> list = new ArrayList<>();
		list.add(r.readLine());
		list.add(r.readLine());
		list.add(r.readLine());
		r.close();
		
		System.out.println(list);
		
		for (int i=0;i<list.size();i++){
			String s = list.get(i);
			list.set(i, "A"+s);
		}
		
		System.out.println(list);

		
		FileWriter file = new FileWriter(UseReadersWriters.FILE_NAME);
		BufferedWriter w = new BufferedWriter(file);
		
		w.write(list.get(0));
		w.newLine();
		w.write(list.get(1));
		w.newLine();
		w.write(list.get(2));
		w.newLine();
		w.close();

	}
}
