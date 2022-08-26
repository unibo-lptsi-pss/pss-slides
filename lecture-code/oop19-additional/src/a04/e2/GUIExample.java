package a04.e2;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final static int SIZE = 4;
    private final Map<JButton,Pair<Integer,Integer>> jbs = new HashMap<>();
    private final Logics logics = new LogicsImpl(SIZE);
    
    public GUIExample() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            Pair<Integer,Integer> p = jbs.get(bt);
            bt.setEnabled(!logics.hit(p.getX(),p.getY()));
            if (logics.isOver()) {
            	System.exit(0);
            }
        };
                
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(al);
                jbs.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
    public static void main(String[] args) {
    	new GUIExample();
    }
}
