package it.unibo.apice.oop.p08polymorphism.person;

public class Student extends Person {
	
	final private int matriculationYear;

	public Student(final String name, final int id, 
			           final int matriculationYear) {
		super(name, id);
		this.matriculationYear = matriculationYear;
	}

	public int getMatriculationYear() {
		return matriculationYear;
	}

	public String toString() {
		return "S [getName()=" + getName() + 
				", getId()=" + getId() +
				", matriculationYear=" + matriculationYear + "]";
	}

}