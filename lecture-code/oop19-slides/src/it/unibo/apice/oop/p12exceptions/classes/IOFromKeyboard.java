package it.unibo.apice.oop.p12exceptions.classes;

import java.io.*;

public class IOFromKeyboard {

	// La dichiarazione throws qui è obbligatoria!
	public static int getIntFromKbd() throws IOException {
		InputStreamReader ISR = new InputStreamReader(System.in);
		BufferedReader keyboardInput = new BufferedReader(ISR);
		String line = null;
		line = keyboardInput.readLine(); // IOException
		return Integer.parseInt(line);
	}

	public static void main(String[] args) throws Exception {
			System.out.print("Inserisci un numero: ");
			int a = getIntFromKbd();
			System.out.println("Hai inserito il num.: " + a);
		
	}
}