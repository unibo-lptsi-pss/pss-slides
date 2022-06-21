package it.unibo.apice.oop.p08polymorphism.person;

public class Person {

    private final String name;
    private final int id;

    public Person(final String name, final int id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
       return "P [name=" + this.name + ", id=" + this.id + "]";
    }
}
