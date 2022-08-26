package it.unibo.apice.oop.p18patterns.fmethod;

import javax.swing.*;

public interface GUIFactory {
	// 3 factory methods
	JPanel createPanel(String text);
	JComponent createButton(String text);
	JComponent createLabel(String text);
	
	// una implementazione "standard"
	class Standard implements GUIFactory{

		@Override
		public JPanel createPanel(String text) {
			return new JPanel();
		}

		@Override
		public JComponent createButton(String text) {
			return new JButton(text);
		}

		@Override
		public JComponent createLabel(String text) {
			return new JLabel(text);
		}	
	}
}
