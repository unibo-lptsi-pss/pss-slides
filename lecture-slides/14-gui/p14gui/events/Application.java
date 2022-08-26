package it.unibo.apice.oop.p15gui.events;

import java.io.*;

public class Application {
	
	private static final String STR = "/home/mirko/aula/15/prova.txt";

	public static void main(String[] args) throws IOException {
		// Genero i 4 oggetti
		KbdInputSource source = new KbdInputSource();
		Adder adder = new Adder();
		ToStream toConsole = new ToStream(System.out);
		PrintStream ps = new PrintStream(new FileOutputStream(STR));
		ToStream toFile = new ToStream(ps);
		
		// Li collego registrando i listener
		adder.addEObserver(toFile);
		adder.addEObserver(toConsole);
		source.addEObserver(adder);
		
		// Faccio partire la applicazione
		source.start();
		ps.close();
	}

}
