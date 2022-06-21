package it.unibo.apice.oop.p08polymorphism.person;

public class UsePerson {

	public static void main(String[] args) {
	    
		final var people = new Person[]{
				new Student("Marco Rossi",334612,2013),
				new Student("Gino Bianchi",352001,2013),
				new Student("Carlo Verdi",354100,2012),
				new Teacher("Mirko Viroli",34121,new String[]{
						"OOP","PPS","PC" 
				})
		};
		
		for (final var p: people){
			System.out.println(p.getName()+": "+p);
		}
	}
}
