package it.unibo.apice.oop.p18concurrency1;

import java.io.*;
import java.util.Date;

public class TestClockWithRunnable {
	static public void main(String[] args) throws Exception {
		
		new Thread(() -> {
			while (true) {
				System.out.println(new Date());
				try {
					Thread.sleep(2000);
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}			
		}).start();

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
