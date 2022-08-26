package it.unibo.apice.oop.p08inheritance.person;

public class Person {
	
	private String name;
	private int id;
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}	
}
