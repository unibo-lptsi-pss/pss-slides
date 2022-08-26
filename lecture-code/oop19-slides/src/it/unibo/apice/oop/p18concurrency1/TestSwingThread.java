package it.unibo.apice.oop.p18concurrency1;

import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame {

  public MyFrame(){
    super("Test Swing thread");
    setSize(200,60);
    setVisible(true);
    JButton button = new JButton("test");
    button.addActionListener((ActionEvent ev) -> {
    		while (true){}
    });
    getContentPane().add(button);
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent ev){
        System.exit(-1);
      }
    });
  }
}

public class TestSwingThread {
  static public void main(String[] args){
	SwingUtilities.invokeLater(() -> { 
		new MyFrame();
		new MyFrame();
	});
  }
}
