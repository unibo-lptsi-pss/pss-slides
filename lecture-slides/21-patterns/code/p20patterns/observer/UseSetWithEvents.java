package it.unibo.apice.oop.p18patterns.observer;

import javax.swing.*;

public class UseSetWithEvents{
	
	public static void main(String[] args){
		SetWithEvents<String> set = new SetWithEvents<>();
		set.addEObserver(new EObserver<Integer>(){
			public void update(ESource<? extends Integer> s, Integer arg) {
				System.out.println("Nuova dim. elenco: "+arg);				
			}
		}); // Aggangio un osservatore che stampa a video
		set.addEObserver(new EObserver<Integer>(){
			public void update(ESource<? extends Integer> s, Integer arg) {
				if (arg > 4){
					JOptionPane.showMessageDialog(null, "Dim. critica");
				}
			}
		}); // Aggangio un osservatore che mostra un OptionPane se > 4
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.add("6");
		System.out.println(set.getCopy());
	}
}
