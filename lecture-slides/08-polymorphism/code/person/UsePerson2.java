package it.unibo.apice.oop.p08inheritance.person;

public class UsePerson2 {

	public static void main(String[] args) {
		
		Person[] people = new Person[]{
				new Student("Marco Rossi",334612,2013),
				new Student("Gino Bianchi",352001,2013),
				new Student("Carlo Verdi",354100,2012),
				new Teacher("Mirko Viroli",34121,new String[]{
						"PO","FINF-A","ISAC" 
				})
		};
		
		for (Person p: people){
			if (p instanceof Student){
				Student s = (Student)p; // Qui non fallisce
				System.out.println(s.getName()+" "+
				                   s.getMatriculationYear());
			}
		}
	}
}
