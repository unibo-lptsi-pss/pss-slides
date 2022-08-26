package it.unibo.apice.oop.p18patterns.singleton;

public class Log {
	// si potrebbe cambiare assegnando una specializzazione
	private static final Log SINGLETON = new Log();
	// rendo invisibile da fuori il costruttore
	private Log(){};
	// torno il singleton
	public static Log getLog(){
		return SINGLETON;
	}
	// metodo del singleton
	public void add(String s){
		System.err.println(s);
	}
	
	// main: non parte del pattern
	public static void main(String[] s){
		Log.getLog().add("Prova 1");
		Log.getLog().add("Prova 2");
	}
}
