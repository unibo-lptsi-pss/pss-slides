package it.unibo.apice.oop.p19reflection.classes;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PrintObjectsUtilities {

	public static String objectToString(Object o, String... getters) {
		try {
			String out = o.getClass().getSimpleName()+": ";
			for (String getter : getters) {
				// Sistemo la maiuscola iniziale
				getter = getter.substring(0,1).toUpperCase() + getter.substring(1);
				// Trovo il getter e lo invoco
				final Method m = o.getClass().getMethod("get" + getter);
				final Object res = m.invoke(o);
				// Aggiungo la stringa
				out += " " + getter + " -> ";
				out += res.getClass().isArray() 
							? Arrays.deepToString((Object[])res) 
							: res.toString();
				out += " |";
			}
			return out.substring(0,out.length()-2);
		} catch (Exception e) {
			return null;
		}
	}
}
