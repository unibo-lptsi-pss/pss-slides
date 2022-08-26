package it.unibo.apice.oop.p08inheritance.person;

public class UsePerson {

	public static void main(String[] args) {
		
		Person[] people = new Person[]{
				new Student("Marco Rossi",334612,2013),
				new Student("Gino Bianchi",352001,2013),
				new Student("Carlo Verdi",354100,2012),
				new Teacher("Mirko Viroli",34121,new String[]{
						"PO","FINF-A","ISAC" 
				})
		};
		// getName() e toString() con late binding
		for (Person p: people){
			System.out.println(p.getName()+": "+p);
		}
	}
}
