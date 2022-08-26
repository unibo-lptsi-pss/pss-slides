package it.unibo.apice.oop.p18concurrency2;

public class A {
    public synchronized void m(){
        System.out.println("INSIDE A - Thread "+Thread.currentThread()+" entered.");
        try {
            Thread.sleep(5000);
        } catch (Exception ex){}
        System.out.println("INSIDE A - Thread "+Thread.currentThread()+" exited.");
    }
}
