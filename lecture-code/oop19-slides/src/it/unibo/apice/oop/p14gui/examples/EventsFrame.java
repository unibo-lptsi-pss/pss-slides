package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EventsFrame {

	private final JButton b1 = new JButton("Say Hello");
	private final JButton b2 = new JButton("Quit");
	private final JButton b3 = new JButton("Looping..");

	public EventsFrame() {
		final MyFrame frame = new MyFrame("Events Example", new FlowLayout());
		frame.getMainPanel().add(b1); // aggiungo i pulsanti
		frame.getMainPanel().add(b2);
		frame.getMainPanel().add(b3);
		final ActionListener listener = new MyActionListener(); //listener unico
		b1.addActionListener(listener);// registro il listener
		b2.addActionListener(listener);// senza actionCommand!!
		b3.addActionListener(listener);
		frame.setVisible(true);
	}

	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) { //switch su getSource
			if (e.getSource()==EventsFrame.this.b1) {
				System.out.println("Hello!!");
			} else if (e.getSource()==EventsFrame.this.b2) {
				System.out.println("Quitting..");
				System.exit(0);
			} else if (e.getSource()==EventsFrame.this.b3) {
				System.out.println("Going stuck..");
				for (; true;) {
				} // Nota l'effetto del loop sulla GUI
			}
		}
	}
	
	public static void main(String[] args){
		new EventsFrame();
	}
}
