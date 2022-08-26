package it.unibo.apice.oop.p21patterns.singleton;

public class LogLazyTS {
	
    // inner static classes are initialised at first use
	private static class LazyHolder {
	    private static final LogLazyTS SINGLETON = new LogLazyTS();
	}

	private LogLazyTS(){};
	
	// Creo il SINGLETON alla prima chiamata
	public static LogLazyTS getLog(){
	    return LazyHolder.SINGLETON;
	}
	// metodo del singleton
	public void add(String s){
		System.err.println(s);
	}
}
