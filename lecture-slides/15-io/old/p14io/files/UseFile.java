package it.unibo.apice.oop.p14io.files;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class UseFile {
	
	public static Iterable<Method> accessors(Class<?> c) throws Exception{
		Collection<Method> list = new ArrayList<Method>();
		for (Method m: c.getMethods()){
			if (m.getParameterTypes().length==0 && 
					m.getName().matches("is.*|get.*|can.*")){ //REGEX
				list.add(m);
			}
		}
		return list;
	} 

	public static void main(String[] args) throws Exception {
		File f;
		if (args.length == 0) {
			f = new File("/home/mirko/aula/14/prova.txt");
		} else {
			f = new File(args[0]);
		}
		for (Method m: accessors(File.class)){
			System.out.println(m.getName()+" "+m.invoke(f));
		}
	}
}
// REGEX: http://docs.oracle.com/javase/tutorial/essential/regex/
