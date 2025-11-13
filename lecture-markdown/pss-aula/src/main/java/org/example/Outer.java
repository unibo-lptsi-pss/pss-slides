package org.example;

public class Padre { // <--- classe outer
    private final String name;

    public Padre(final String name) {
        this.name = name;
    }
    public static class Cugino { // <--- classe nested
        public void sayGreetToPadre(final Padre padre) {
            System.out.println("Hello! " + padre.name);
        }
    }
}
