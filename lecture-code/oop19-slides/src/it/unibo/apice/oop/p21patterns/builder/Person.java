package it.unibo.apice.oop.p21patterns.builder;

import java.util.Optional;

public class Person {
	
	final private String name;
	final private String surname;
	final private Optional<String> city;
	final private int year;
	
	private Person(String name, String surname, Optional<String> city, int year) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.year = year;
	}
	
	
	public static class Builder{
	
		private String name;
		private String surname;
		private Optional<String> city = Optional.empty();
		private Optional<Integer> year = Optional.empty();
		
		public Builder(String name, String surname){
			this.name = name;
			this.surname = surname;
		}
		
		public Builder city(String s){
			this.city = Optional.ofNullable(s);
			return this;
		}
		
		public Builder year(int i){
			this.year = Optional.of(i).filter(k->k>=1900 || k<=2015);
			return this;
		}
		
		public Person build() throws IllegalStateException{
			if (this.name == null || this.surname == null || !this.year.isPresent()){
				throw new IllegalStateException("");
			}
			return new Person(this.name,this.surname,this.city,this.year.get());
		}
		
		
	}
	
	
	
	

}
