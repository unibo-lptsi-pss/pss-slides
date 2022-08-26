package it.unibo.apice.oop.p17streams;

import java.util.*;

public class Person {
	
	private final String name;
	private final Optional<String> city;
	private final double income;
	private final Set<String> jobs;
	
	public Person(String name, String city, double income, String... jobs) {
		this.name = Objects.requireNonNull(name);
		this.city = Optional.ofNullable(city); // null in ingresso indica città assente
		this.income = income;
		this.jobs = new HashSet<>(Arrays.asList(jobs)); // conversione a set
	}

	public String getName() {
		return this.name;
	}

	public Optional<String> getCity() {
		return this.city;
	}

	public double getIncome() {
		return this.income;
	}
	
	public Set<String> getJobs(){
		return Collections.unmodifiableSet(this.jobs);	// copia difensiva
	}
	//.. seguono hashCode, equals e toString
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", income=" + income
				+ ", jobs=" + jobs + "]";
	}	
	
	
}
