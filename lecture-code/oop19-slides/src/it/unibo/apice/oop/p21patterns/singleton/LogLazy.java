package it.unibo.apice.oop.p21patterns.singleton;

public class LogLazy {
	
	private static LogLazy SINGLETON = null;

	private LogLazy(){};
	
	// Creo il SINGLETON alla prima chiamata
	public static LogLazy getLog(){
		if (SINGLETON == null){
			SINGLETON = new LogLazy();
		}
		return SINGLETON;
	}
	// metodo del singleton
	public void add(String s){
		System.err.println(s);
	}
}
