package it.unibo.apice.oop.p21patterns.observer.auladone;

import java.util.*;
import javax.swing.*;

public class FieldGUIImpl implements FieldGUI {
    
    private List<Observer> observers = new LinkedList<Observer>();
    
    public FieldGUIImpl(){
        JFrame jf = new JFrame("FieldGUI");
        jf.setSize(320, 200);
        JTextField field = new JTextField(20);
        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            observers.forEach(obs -> obs.valueInserted(field.getText()));
        });
        JPanel panel = new JPanel();
        jf.getContentPane().add(panel);
        panel.add(field);
        panel.add(button);
        jf.setVisible(true);
    }
    
    @Override
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

}
