package it.unibo.apice.oop.p14gui.examples;

import java.awt.*;
import javax.swing.*;

/* Specializzazione di JFrame:
 * - JFrame è Serializable!
 * - Il costruttore accetta titolo e layout-manager
 * - Si aggiunge il JPanel
 * - Un metodo getMainPanel() ci dà il pannello
 */
public class MyFrame extends JFrame{
	
	private final JPanel jp;
	
	public MyFrame(String title, LayoutManager lm){
		super(title); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320,200);
		// Il layout-manager può essere passato al costruttore di JPanel
		this.jp = new JPanel(lm);
		this.getContentPane().add(this.jp);
	}
	
	public JPanel getMainPanel(){
		return this.jp;
	}

}
