package it.unibo.apice.oop.p18concurrency2;

public class TestUserA {
    public static void main(String[] args) {
        A obj = new A();
        UserA userA = new UserA("pippo",obj);
        UserA userB = new UserA("pluto",obj);
        userA.start();        
        try {
            Thread.sleep(500);
        } catch (Exception ex){}        
        userB.start();
    }
}
