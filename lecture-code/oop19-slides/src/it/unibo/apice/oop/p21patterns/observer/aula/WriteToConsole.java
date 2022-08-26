package it.unibo.apice.oop.p21patterns.observer.aula;

public class WriteToConsole implements Observer {

    @Override
    public void notifyStringInserted(String s) {
        System.out.println(s);
    }

}
