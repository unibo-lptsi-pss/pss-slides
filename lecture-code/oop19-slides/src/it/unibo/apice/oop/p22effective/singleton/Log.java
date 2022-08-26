package it.unibo.apice.oop.p22effective.singleton;

public enum Log {
	
	SINGLETON;
	
	// Codice del singleton vero e proprio
	
	
	private int counter = 0;
	
	public void add(String s){
		System.err.println((this.counter++)+" "+s);
	}
	
	// Un main di prova
	
	public static void main(String[] args){
		Log.SINGLETON.add("errore..");
		Log.SINGLETON.add("warning..");
		Log.SINGLETON.add("uscita..");
	}
}
