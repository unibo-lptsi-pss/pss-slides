class A{
	static { System.out.println("A.class caricato");}
}

class B extends A{
	static { System.out.println("B.class caricato");}
}

public class Loading {
	static { System.out.println("Loading.class caricato");}

	public static void main(String[] args) {
		System.out.println("main partito");
		new B();
		System.out.println("creato un oggetto di B");
	} 
	/*	Loading.class caricato
		main partito
		A.class caricato
		B.class caricato
		creato un oggetto di B */
}
