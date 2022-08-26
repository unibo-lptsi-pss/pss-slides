package it.unibo.apice.oop.p21patterns.factory.person;

public interface PersonFactory {

    Person createBasic(String name, String surname);

    Person createAdvanced(String name, String surname, String city);

}