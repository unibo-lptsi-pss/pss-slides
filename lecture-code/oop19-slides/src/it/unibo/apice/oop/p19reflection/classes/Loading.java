package it.unibo.apice.oop.p19reflection.classes;

class A{
	static { System.out.println("A.class caricato");}
	{ System.out.println("A.class istanziato"); }
	{ System.out.println("A.class istanziato"); }
}

class B extends A{
	static { System.out.println("B.class caricato");}
	{ System.out.println("B.class istanziato"); }
}

public class Loading {
	static { System.out.println("Loading.class caricato");}

	public static void main(String[] args) {
		System.out.println("main partito");
		new B();
		System.out.println("creato un oggetto di B");
	}
	/*  Loading.class caricato
		main partito
		A.class caricato
		B.class caricato
		A.class istanziato
		A.class istanziato
		B.class istanziato
		creato un oggetto di B  */
}
