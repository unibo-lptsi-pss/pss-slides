package it.unibo.apice.oop.p19reflection.annotations;

public class Person {
	
	private final String name;
	private final int id;
	
	public Person(final String name, final int id) {
		this.name = name;
		this.id = id;
	}
	
	@ToString
	public String getName() {
		return name;
	}

	@ToString 
	public int getId() {
		return id;
	}
}
