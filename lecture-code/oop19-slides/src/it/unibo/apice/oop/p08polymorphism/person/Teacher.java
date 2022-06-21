package it.unibo.apice.oop.p08polymorphism.person;

import java.util.Arrays;

public class Teacher extends Person {
	
	final private String[] courses;

	public Teacher(final String name, final int id, 
			           final String[] courses) {
		super(name, id);
		this.courses = courses;
	}

	public String[] getCourses() {
		// copia difensiva necessaria a preservare incapsulamento
		return Arrays.copyOf(courses,courses.length);
	}

	public String toString() {
		return "T [getName()=" + getName() + 
				", getId()=" + getId() + 
				", courses=" + Arrays.toString(courses) + "]";
	}
}
