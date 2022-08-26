package it.unibo.apice.oop.p19reflection.classes;

import java.io.*;
import java.lang.reflect.*;

public class DynamicExecution {

	private static final String Q_CLASS = "Insert fully-qualified class name: ";
	private static final String Q_METH = "Insert name of method to call: ";
	private static final String L_OK = "Everything was ok! The result is..";
	private static final String E_RET = "Wrong return type";

	public static void main(String[] s) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println(Q_CLASS);
			final String className = reader.readLine();
			System.out.println(Q_METH);
			final String methName = reader.readLine();
			final Class<?> cl = Class.forName(className);	// Ottiene la classe
			final Constructor<?> cns = cl.getConstructor(); // Ottiene il costruttore
			final Method met = cl.getMethod(methName);      // Ottiene il metodo
			if (!met.getReturnType().isAssignableFrom(String.class)) {
				throw new NoSuchMethodException(E_RET);		// Il metodo deve tornare String
			}
			final Object o = cns.newInstance();             // Istanzia l'oggetto
			final String result = (String) met.invoke(o);   // Chiama il metodo
			System.out.println(L_OK);
			System.out.println(result);
			System.out.println();
		}
	}
}
