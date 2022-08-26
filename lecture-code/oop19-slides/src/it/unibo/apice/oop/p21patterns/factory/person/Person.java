package it.unibo.apice.oop.p21patterns.factory.person;

import java.util.Optional;

public interface Person {

    String getName();

    String getSurname();

    Optional<String> getCity();

    int getYear();

}