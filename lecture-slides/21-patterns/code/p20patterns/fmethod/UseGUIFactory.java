package it.unibo.apice.oop.p18patterns.fmethod;

import javax.swing.*;

public class UseGUIFactory {

	public static void main(String[] args) {
		GUIFactory factory = new MyGUIFactory();
		//GUIFactory factory = new GUIFactory.Standard();
		
		JFrame frame = new JFrame("Testing GUIFactory");
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = factory.createPanel("main");
		panel.add(factory.createLabel("Label.."));
		panel.add(factory.createButton("Button.."));
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}
