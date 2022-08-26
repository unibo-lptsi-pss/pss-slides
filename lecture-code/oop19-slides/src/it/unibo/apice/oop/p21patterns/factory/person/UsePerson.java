package it.unibo.apice.oop.p21patterns.factory.person;

import java.util.Optional;

public class UsePerson {
    
    public static void main(String[] args){
        PersonFactory pf = new PersonFactoryImpl();
        Person p1 = pf.createBasic("mario", "rossi");
        Person p2 = pf.createAdvanced("mario", "rossi","cesena");
        
    }

}
