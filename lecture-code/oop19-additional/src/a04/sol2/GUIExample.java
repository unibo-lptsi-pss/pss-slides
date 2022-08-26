package a04.sol2;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final static int SIZE = 6;
    private final List<JButton> jbs = new ArrayList<>();
    
    public GUIExample() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            System.out.println(jbs.indexOf(bt));
        	bt.setEnabled(false);
        };
                
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(al);
                jbs.add(jb);
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
    public static void main(String[] args) {
    	new GUIExample();
    }
}
