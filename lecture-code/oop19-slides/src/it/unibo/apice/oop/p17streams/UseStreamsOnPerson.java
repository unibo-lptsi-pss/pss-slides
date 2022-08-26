package it.unibo.apice.oop.p17streams;

import java.util.*;

public class UseStreamsOnPerson {

	public static void main(String[] args) {
		
		final List<Person> list = new ArrayList<>();
		list.add(new Person("Mario","Cesena",20000,"Teacher"));
		list.add(new Person("Rino","Forlì",50000,"Professor"));
		list.add(new Person("Lino","Cesena",110000,"Professor","Dean"));
		list.add(new Person("Ugo","Cesena",20000,"Secretary"));
		list.add(new Person("Marco",null,4000,"Contractor"));
		
		final double result = list.stream()
								  .filter(p->p.getCity().isPresent())
								  .filter(p->p.getCity().get().equals("Cesena"))
								  .mapToDouble(Person::getIncome)
								  .sum();
	
		System.out.println(result);
		
		// alternativa con iteratore: qual è la più leggibile?
		double res2 = 0.0;
		for (final Person p: list){
			if (p.getCity().isPresent() && p.getCity().get().equals("Cesena")){
				System.out.println(p);
				res2 = res2 + p.getIncome();
			}
		}
		System.out.println(res2);
	}
}   
