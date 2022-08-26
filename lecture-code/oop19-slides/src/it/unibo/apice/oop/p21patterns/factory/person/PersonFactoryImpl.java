package it.unibo.apice.oop.p21patterns.factory.person;

import java.util.Optional;

public class PersonFactoryImpl implements PersonFactory {
    
    @Override
    public Person createBasic(String name, String surname) {
        return new PersonImpl(name,surname,Optional.empty(),1900);
    }
    
    @Override
    public Person createAdvanced(String name, String surname, String city) {
        return new PersonImpl(name,surname,Optional.of(city),1900);
    }
    
    

}
