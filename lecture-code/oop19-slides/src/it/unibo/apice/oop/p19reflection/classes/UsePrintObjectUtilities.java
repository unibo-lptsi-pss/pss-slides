package it.unibo.apice.oop.p19reflection.classes;

import static it.unibo.apice.oop.p19reflection.classes.PrintObjectsUtilities.*;

public class UsePrintObjectUtilities {
	
	public static void main(String[] args) {
		Person p = new Person("Mario",101);
		Teacher t = new Teacher("Gino",102,"PC","OOP");
		System.out.println(objectToString(p));
		System.out.println(objectToString(p,"name"));
		System.out.println(objectToString(p,"name","id"));
		System.out.println(objectToString(t,"name","id","courses"));
		
		Counter c = new Counter();
		c.increment();
		c.increment();
		System.out.println(objectToString(c,"value"));
		
	}

}
