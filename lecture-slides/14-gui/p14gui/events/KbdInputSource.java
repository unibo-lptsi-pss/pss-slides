package it.unibo.apice.oop.p15gui.events;

import java.util.*;
import java.io.*;

public class KbdInputSource extends ESource{
	
	// Metodo di partenza
	public void start(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int i = 0;
		while(i>=0){ // Con valori negativi esco..
			try{
				String s = br.readLine(); // leggo
				i = Integer.parseInt(s);  // interpreto
				this.notifyEObservers(i); // notifico
			} catch (IOException e){
				System.out.println("Not understood, try again..");
			}
		}
	}
}
