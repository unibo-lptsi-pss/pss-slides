package it.unibo.apice.oop.p15gui.examples;

import java.awt.event.*;

// Nota: si potrebbero usare delle inner class
public class MyActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("hello")){
			System.out.println("Hello!!");
		} else if (e.getActionCommand().equals("quit")){
			System.out.println("Quitting..");
			System.exit(0);
		} else if (e.getActionCommand().equals("loop")){
			System.out.println("Going stuck..");
			for(;true;){} // Nota l'effetto del loop sulla GUI
		}
	}
}
