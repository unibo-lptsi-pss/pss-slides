package it.unibo.apice.oop.p21patterns.singleton;

public class OtherLog {

	static public void add(String s){
		System.err.println(s);
	}
	
	// main: non parte del pattern
	public static void main(String[] s){
		OtherLog.add("Prova 1");
		OtherLog.add("Prova 2");
	}

}
