package it.unibo.apice.oop.p19reflection.classes;

import java.lang.reflect.*;

public class Example {

	public static void main(String[] args) throws Exception{
		Class<?> c = Class.forName("it.unibo.apice.oop.p14reflection.classes.Counter");
		System.out.println(c);
		
		Object o = c.newInstance();
		//Object o = new Counter();
		
		Field f = c.getDeclaredField("countValue");
		
		System.out.println(f);
		
		System.out.println(f.get(o));
		//System.out.println(((Counter)o).getValue());
		
		

	}

}
