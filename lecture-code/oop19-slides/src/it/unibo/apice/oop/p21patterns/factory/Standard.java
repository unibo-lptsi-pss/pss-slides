package it.unibo.apice.oop.p21patterns.factory;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public // una implementazione "standard"
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

