package it.unibo.apice.oop.p21patterns.builder;

/*
 * Builder implementato come member class e stile "fluent"
 */

public class UsePersonBuilder {

	public static void main(String[] args) {
		
		final Person p = new Person.Builder("Mirko", "Viroli")
		                           .city("Cesena")
		                           .year(1973)
		                           .build();
		
		// Creazione errata, intercettata dalla logica del Builder
		final Person p2 = new Person.Builder("Gino","Bianchi")
        				            //.year(2016)
        				            .build();

	}
}
