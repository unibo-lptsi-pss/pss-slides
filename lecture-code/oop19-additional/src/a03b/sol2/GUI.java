package a03b.sol2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private List<JButton> buttons = null; // Java hack to ensure initialisation :(
    private JCheckBox left = null; // Java hack to ensure initialisation :(
    private final Logics logics;
    private final static int SIZE = 5;
    
    public GUI() {
        this.logics = new LogicsImpl(SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*(SIZE*3), 40);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            if (left.isSelected()) {
            	this.logics.toLeft(buttons.indexOf(bt));
            } else {
            	this.logics.toRight(buttons.indexOf(bt));
            }
            drawAndPossiblyQuit();
        };
        
        JPanel panelTop = new JPanel(new FlowLayout());
        this.buttons = IntStream.range(0,SIZE)
        		                .mapToObj(i->new JButton(""))
        		                .peek(panelTop::add)
        		                .peek(jb->jb.addActionListener(al))
        		                .collect(Collectors.toList());
        this.left = new JCheckBox("left");
        panelTop.add(this.left);
        this.getContentPane().add(BorderLayout.CENTER,panelTop);
        this.drawAndPossiblyQuit();
        this.pack();
        this.setVisible(true);
    }
    
    private void drawAndPossiblyQuit() {
    	if (logics.isDone()) {
    		System.exit(0);
    	}
    	List<Integer> numbers = this.logics.getNumbers();
    	for (int i=0; i<SIZE; i++) {
    		this.buttons.get(i).setText(String.valueOf(numbers.get(i)));
    	}
    }
    
}
