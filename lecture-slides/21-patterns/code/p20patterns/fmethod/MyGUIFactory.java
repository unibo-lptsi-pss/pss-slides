package it.unibo.apice.oop.p18patterns.fmethod;

import java.awt.Color;
import javax.swing.*;

public class MyGUIFactory implements GUIFactory{
	
	private ImageIcon icon = new ImageIcon(MyGUIFactory.class.getResource("/italy.jpg"));

	@Override
	public JPanel createPanel(String text) {
		JPanel p = new JPanel();
		p.setBorder(new javax.swing.border.TitledBorder(text));
		return p;
	}

	@Override
	public JComponent createButton(String text) {;
	    JButton b = new JButton(text, icon);
	    b.setBackground (new Color(255,255,255));
		return b;
	}

	@Override
	public JComponent createLabel(String text) {
		JLabel j = new JLabel(text);
		j.setIcon(icon);
		return j;
	}
}
