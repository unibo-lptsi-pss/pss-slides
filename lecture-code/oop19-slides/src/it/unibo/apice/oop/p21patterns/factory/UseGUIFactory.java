package it.unibo.apice.oop.p21patterns.factory;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class UseGUIFactory {

	public static void main(String[] args) {
		
		//System.out.println(Arrays.toString(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()));
		//final GUIFactory factory = new MyGUIFactory();
		final GUIFactory factory = new Standard();
		
		final JFrame frame = new JFrame("Testing GUIFactory");
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = factory.createPanel("main");
		panel.add(factory.createLabel("Label.."));
		panel.add(factory.createButton("Button.."));
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}
