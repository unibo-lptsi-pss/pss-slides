package app;

import java.awt.FlowLayout;
import java.util.*;
import javax.swing.*;

public class DrawNumberViewImpl implements DrawNumberView {
	
	private final Set<DrawNumberController> controllerSet = new HashSet<>();
	private final JFrame jf = new JFrame("DrawNumber");
	
	public DrawNumberViewImpl() {
		JTextField tf = new JTextField(10);
		JButton bd = new JButton("Draw");
		JButton quit = new JButton("Quit");
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(tf);
		panel.add(bd);
		panel.add(quit);
		quit.addActionListener(e->System.exit(1));
		bd.addActionListener(e->{
			try {
				int number = Integer.parseInt(tf.getText());
				this.controllerSet.forEach(c->c.newDraw(number));
			} catch (Exception ex) {
				this.showDialog("A number please...");
			}
		});
		jf.getContentPane().add(panel);
		jf.pack();
		jf.setVisible(true);
	}
	
	private void showDialog(String msg) {
		JOptionPane.showMessageDialog(this.jf, msg);
	}
	
	@Override
	public void numberTooHigh() {
		this.showDialog("Too high");
	}

	@Override
	public void numberTooLow() {
		this.showDialog("Too low");
	}

	@Override
	public void won() {
		this.showDialog("You won");
	}

	@Override
	public void notInRange() {
		this.showDialog("Wrong range");
	}

	@Override
	public void outOfMoves() {
		this.showDialog("You failed");
	}

	@Override
	public void addController(DrawNumberController controller) {
		this.controllerSet.add(controller);
	}

}
