package it.unibo.apice.oop.p19reflection.classes;

import java.lang.reflect.Field;

class C{
	private static String s = "prova";
}

public class TryAccessField {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
		//Class<Prova> cl = Prova.class;
		
		//Field f = cl.getField("s");
		
		//f.set(cl, "prova2");
		
//		System.out.println(C.s);
		
	}
}
