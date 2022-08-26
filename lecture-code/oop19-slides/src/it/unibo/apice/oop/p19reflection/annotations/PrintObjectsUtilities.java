package it.unibo.apice.oop.p19reflection.annotations;

import java.lang.reflect.Method;

public class PrintObjectsUtilities {

	public static String objectToString(Object o) {
		try {
			String out = "";
			for (final Method m : o.getClass().getMethods()) {
				if (m.isAnnotationPresent(ToString.class) && m.getParameterTypes().length==0){
					final ToString annotation = m.getAnnotation(ToString.class);
					out += annotation.customName().equals("") ? m.getName() 
					                                          : annotation.customName();
					out += annotation.associationSymbol();
					out += m.invoke(o) + annotation.separator() + " ";
				}
			}
			return out;
		} catch (Exception e) {
			return null;
		}
	}
}
