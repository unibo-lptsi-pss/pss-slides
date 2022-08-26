package it.unibo.apice.oop.p21patterns.observer.aula;

public class App {

    public static void main(String[] args) {
        final FieldGUI gui = new FieldGUI();
        gui.addObserver(new WriteToConsole());
        gui.addObserver(new Terminator());
    }

}
