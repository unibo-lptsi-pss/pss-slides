package it.unibo.apice.oop.p19reflection.classes;

import java.lang.reflect.*;

public class ExampleObject {

	public static void main(String[] args) throws Exception{
		Class<?> c = Class.forName("it.unibo.apice.oop.p16reflection.classes.Counter");
		System.out.println(c);
		
		Object o = c.newInstance();
		
		Field f = c.getDeclaredField("countValue");
		System.out.println(f);
		

	}

}
