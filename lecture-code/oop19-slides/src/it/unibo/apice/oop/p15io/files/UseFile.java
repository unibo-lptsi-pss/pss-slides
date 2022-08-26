package it.unibo.apice.oop.p15io.files;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class UseFile {

	public static final String SEP = File.separator;
	// public static final String FILE_NAME = "/home/mirko/aula/15/Prova.bin"; // non portabile!!
	public static final String FILE_NAME = System.getProperty("user.home") + SEP + "aula" + SEP + "15" + SEP + "Prova.bin";

	private static Iterable<Method> accessors(Class<?> c) throws Exception {
		final Collection<Method> list = new ArrayList<>();
		for (final Method m : c.getMethods()) {
			if (m.getParameterTypes().length == 0
					&& m.getName().matches("is.*|get.*|can.*")) { // REGEX
				list.add(m);
			}
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		final File f = new File( args.length == 0 ? FILE_NAME : args[0]);
		for (final Method m : accessors(File.class)) {
			System.out.println(m.getName() + " " + m.invoke(f));
		}
	}
}
// REGEX: http://docs.oracle.com/javase/tutorial/essential/regex/
