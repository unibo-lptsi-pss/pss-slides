package a03b.e2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class GUIExample extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private List<JButton> buttons; 
    private JCheckBox box; 
    
    public GUIExample() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ActionListener al = (e)->{
            final JButton bt = (JButton)e.getSource();
            bt.setText("*");
            System.out.println(box.isSelected()+" "+buttons.indexOf(bt));
        };
        
        JPanel panel = new JPanel(new FlowLayout());
        this.buttons = IntStream.range(0,20)
        		                .mapToObj(i->new JButton("  "))
        		                .peek(panel::add)
        		                .peek(jb->jb.addActionListener(al))
        		                .collect(Collectors.toList());
        this.box = new JCheckBox("box");
        panel.add(this.box);
        this.getContentPane().add(BorderLayout.CENTER,panel);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) throws java.io.IOException {
        new GUIExample();
    }
    
}
