package it.unibo.apice.oop.p21patterns.observer.aula;

import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class FieldGUI {
    
    private List<Observer> observers = new LinkedList<>();
    
    public FieldGUI(){
        JFrame jf = new JFrame("FieldGUI");
        jf.setSize(320, 200);
        JTextField field = new JTextField(20);
        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            observers.forEach(obs -> obs.notifyStringInserted(field.getText()));
        });
        JPanel panel = new JPanel();
        jf.getContentPane().add(panel);
        panel.add(field);
        panel.add(button);
        jf.setVisible(true);
    }
    
    public void addObserver(Observer obs){
        this.observers.add(obs);
    }
    
    
}
