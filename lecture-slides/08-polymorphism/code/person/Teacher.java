package it.unibo.apice.oop.p08inheritance.person;

import java.util.Arrays;

public class Teacher extends Person {
	
	private String[] courses;

	public Teacher(String name, int id, String[] courses) {
		super(name, id);
		this.courses = courses;
	}

	public String[] getCourses() {
		return courses;
	}

	public String toString() {
		return "Teacher [getName()=" + getName() + 
		       ", getId()=" + getId() + 
		       ", courses=" + Arrays.toString(courses) + "]";
	}
}
