package it.unibo.apice.oop.p17streams;

import java.util.*;
import java.util.stream.*;


public class UseStreamsOnPerson2 {

	public static void main(String[] args) {
		
		final List<Person> list = new ArrayList<>();
		list.add(new Person("Mario","Cesena",20000,"Teacher"));
		list.add(new Person("Rino","Forlì",50000,"Professor"));
		list.add(new Person("Lino","Cesena",110000,"Professor","Dean","Secretary"));
		list.add(new Person("Ugo","Cesena",20000,"Secretary"));
		list.add(new Person("Marco",null,4000,"Contractor"));
		
		// Jobs of people from Cesena
		final String res = 
				list.stream()
				    .filter(p->p.getCity().filter(x->x.equals("Cesena")).isPresent())
					.flatMap(p->p.getJobs().stream())
					.distinct()
					.collect(Collectors.joining("|", "[[", "]]"));
		System.out.println(res);
		
		// Average income of professors
		final double avg = 
				list.stream()
				    .filter(p->p.getJobs().contains("Professor"))
					.mapToDouble(Person::getIncome)
					.average().getAsDouble();
		
		System.out.println(avg);
		System.out.println(
				list.stream()
				    .filter(p->p.getJobs().contains("Professor"))
				    .mapToDouble(Person::getIncome).average());
	}
}   
