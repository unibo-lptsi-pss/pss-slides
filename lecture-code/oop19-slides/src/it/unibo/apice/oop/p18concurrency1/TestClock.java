package it.unibo.apice.oop.p18concurrency1;

import java.io.*;

public class TestClock {
	static public void main(String[] args) throws Exception {
		Clock clock = new Clock(2000);
		clock.start(); 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		System.out.println("READY");
		do {
			input = reader.readLine();
			System.out.println("eco: "+input);
		} while (!input.equals("exit"));	
		System.exit(0);			
	}
}
