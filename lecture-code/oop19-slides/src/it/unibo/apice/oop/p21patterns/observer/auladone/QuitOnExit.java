package it.unibo.apice.oop.p21patterns.observer.auladone;

public class QuitOnExit implements Observer {

    @Override
    public void valueInserted(String s) {
        if (s.equals("exit")){
            System.exit(1);
        }
    }

}
