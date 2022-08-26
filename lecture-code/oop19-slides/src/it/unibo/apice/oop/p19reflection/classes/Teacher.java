package it.unibo.apice.oop.p19reflection.classes;

import java.util.Arrays;

public class Teacher extends Person {
	
	private String[] courses;

	public Teacher(String name, int id, String... courses) {
		super(name, id);
		this.courses = courses;
	}

	public String[] getCourses() {
		return courses;
	}

	public String toString() {
		return "Teacher [getName()=" + getName() + ", getId()=" + getId()
				+ ", courses=" + Arrays.toString(courses) + "]";
	}
}
