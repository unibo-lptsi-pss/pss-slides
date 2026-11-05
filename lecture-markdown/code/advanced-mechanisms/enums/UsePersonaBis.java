package enums;

import java.util.ArrayList;
import java.util.List;

public class UsePerson {
    public static void main(String[] args){
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Mario","Rossi",Person.EMILIA_ROMAGNA));
        list.add(new Person("Gino","Bianchi",3));
        list.add(new Person("Carlo","Verdi",Person.LOMBARDIA)); 
        // Non si hanno errori sulle stringhe
        // Non si può prevenire l'uso diretto di interi..
        ...
    }
}
