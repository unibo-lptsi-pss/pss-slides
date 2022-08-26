package it.unibo.apice.oop.p21patterns.factory.alternate;

import javax.swing.*;

public interface GUIFactory {
	
	// 3 factory methods, in questo caso con implementazione di default
	default JPanel createPanel(String text){
		return new JPanel();
	}
	default JComponent createButton(String text){
		return new JButton(text);
	}
	default JComponent createLabel(String text){
		return new JLabel(text);
	}
	
	// Torna una implementazione di default
	public static GUIFactory createStandard(){
		return new GUIFactory(){};
	}
	 
}
