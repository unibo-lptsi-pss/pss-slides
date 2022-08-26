package it.unibo.apice.oop.p08inheritance.person;

public class Student extends Person {
	
	private int matriculationYear;

	public Student(String name, int id, int matriculationYear) {
		super(name, id);
		this.matriculationYear = matriculationYear;
	}

	public int getMatriculationYear() {
		return matriculationYear;
	}

	public String toString() {
		return "Student [getName()=" + getName() + 
		        ", getId()=" + getId() + 
		        ", matriculationYear=" + matriculationYear + "]";
	}
}
