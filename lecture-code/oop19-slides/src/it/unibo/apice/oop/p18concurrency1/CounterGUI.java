package it.unibo.apice.oop.p18concurrency1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CounterGUI extends JFrame 
                        implements ActionListener, CounterEventListener {

	private JButton start;
	private JButton stop;
	private JButton reset;
	private JTextField display;
	
	private Counter counter;
	private CounterAgent agent;
	
	public CounterGUI(Counter c){
		setTitle("Counter GUI");
		setSize(300,100);		
		counter = c;		
		display = new JTextField(5);
		display.setEditable(false);		
		display.setText(""+ c.getValue());
		start = new JButton("start");
		stop  = new JButton("stop");
		reset = new JButton("reset");
		stop.setEnabled(false);
		
		Container cp = getContentPane();
		JPanel panel = new JPanel();
		
		Box p0 = new Box(BoxLayout.X_AXIS);
		p0.add(display);
		Box p1 = new Box(BoxLayout.X_AXIS);
		p1.add(start);
		p1.add(stop);
		p1.add(reset);
		Box p2 = new Box(BoxLayout.Y_AXIS);
		p2.add(p0);
		p2.add(Box.createVerticalStrut(10));
		p2.add(p1);
		
		panel.add(p2);
		cp.add(panel);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(WindowEvent ev){
				System.exit(-1);
			}
		});

		start.addActionListener(this);
		stop.addActionListener(this);
		reset.addActionListener(this);
		counter.addListener(this);
	}
	
	public void actionPerformed(ActionEvent ev){
		Object src = ev.getSource();
		if (src==start){			
			agent = new CounterAgent(counter);
			agent.start();			
			start.setEnabled(false);
			stop.setEnabled(true);
			reset.setEnabled(false);			
		} else if (src == stop){
			agent.interrupt();
			start.setEnabled(true);
			stop.setEnabled(false);
			reset.setEnabled(true);
		} else if (src == reset){
			counter.reset();
		}
	}
	
	public void counterChanged(final CounterEvent ev){
		SwingUtilities.invokeLater(()-> {
				display.setText(""+ ev.getValue());
		});
	}
}
