public class A {
	void metodo(int x){}
}

class B extends A{
	@Override
	void metod(int x){} // Il compilatore segnala errore
}

