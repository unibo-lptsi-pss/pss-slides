package it.unibo.apice.oop.p21patterns.observer.aula;

public class Terminator implements Observer {

    @Override
    public void notifyStringInserted(String s) {
        if (s.equals("exit")){ 
            System.exit(1);
        }
    }

}
