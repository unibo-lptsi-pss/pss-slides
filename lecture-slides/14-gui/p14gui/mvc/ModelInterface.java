package it.unibo.apice.oop.p15gui.mvc;

public interface ModelInterface extends Iterable<Person>{
	
	void clear();
	void save(java.io.OutputStream os) throws java.io.IOException;
	void load(java.io.InputStream is) throws java.io.IOException, java.lang.ClassNotFoundException;
	void add(String name, String surname, String code, int birthYear, boolean male) throws DataIncorrectException;
	java.util.Iterator<Person> iterator();
}
