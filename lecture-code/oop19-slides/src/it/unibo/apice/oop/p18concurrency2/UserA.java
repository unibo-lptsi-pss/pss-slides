package it.unibo.apice.oop.p18concurrency2;

public class UserA extends Thread {
    private A obj;
    public UserA(String name, A obj){
    	super(name);
        this.obj = obj;
    }
    public void run(){
        log("before invoking m");
        obj.m();
        log("after invoking m");
    }
    
    private void log(String msg){
        System.out.println("["+Thread.currentThread()+"] "+msg);
    }
}
