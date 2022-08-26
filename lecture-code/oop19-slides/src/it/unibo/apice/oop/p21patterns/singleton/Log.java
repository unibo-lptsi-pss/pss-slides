package it.unibo.apice.oop.p21patterns.singleton;

public class Log {
	// si potrebbe cambiare assegnando una specializzazione
	private static final Log SINGLETON = new Log();
	// rendo invisibile da fuori il costruttore (o protected)
	private Log(){};
	// torno il singleton
	public static Log getLog(){
		return SINGLETON;
	}
	// da qui seguono i metodi istanza
	// unico metodo di questo singleton
	public void add(String s){
		System.err.println(s);
	}
}
