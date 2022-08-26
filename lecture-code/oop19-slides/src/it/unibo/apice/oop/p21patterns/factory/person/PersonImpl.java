package it.unibo.apice.oop.p21patterns.factory.person;

import java.util.Optional;

public class PersonImpl implements Person {
	
	private String name;
	private String surname;
	private Optional<String> city = Optional.empty();
	private int year = 1900;
	
    PersonImpl(String name, String surname, Optional<String> city, int year) {
        super();
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public Optional<String> getCity() {
        return city;
    }
    @Override
    public int getYear() {
        return year;
    }
}
