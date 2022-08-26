package it.unibo.apice.oop.p16lambda.optional;

import java.util.*;

public class Person {
	
	private final String name;
	private Optional<Person> partner = Optional.empty();
	
	public Person(final String name) {
		this.name = Objects.requireNonNull(name);
	}
	
	public String getName() {
		return this.name;
	}

	public Optional<Person> getPartner() {
		return this.partner;
	}
	
	public void setPartner(final Person p){
		this.partner = Optional.of(Objects.requireNonNull(p));
	}
	
	public void removePartner(){
		this.partner = Optional.empty();
	}
	
	public Optional<String> getPartnerName(){
		return this.partner.map(Person::getName);
	}
}
