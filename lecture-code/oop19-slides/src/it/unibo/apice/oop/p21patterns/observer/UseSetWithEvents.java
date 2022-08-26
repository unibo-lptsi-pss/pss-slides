package it.unibo.apice.oop.p21patterns.observer;

import javax.swing.*;

public class UseSetWithEvents{
	
	public static void main(String[] args){
		final SetWithEvents<String> set = new SetWithEvents<>();
		set.addEObserver((s,arg)->System.out.println("Nuova dim. elenco: "+arg)); 
		// Aggangio un osservatore che stampa a video
		set.addEObserver((s,arg)-> {
			if (arg > 4){
				SwingUtilities.invokeLater(
					()->JOptionPane.showMessageDialog(null, "Dim. critica"));
			}
		});
		// Aggangio un osservatore che mostra un OptionPane se > 4
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("6");
		System.out.println(set.getCopy());
	}
}
