package it.unibo.apice.oop.p15gui.mvc;

import java.io.*;
import java.util.*;

public class Model extends HashSet<Person> implements ModelInterface {

	private static final long serialVersionUID = 131818814922065489L;

	private static final String WRONG_NAME = "Wrong name";
	private static final String WRONG_SURNAME = "Wrong surname";
	private static final String WRONG_CODE = "Wrong code";
	private static final String WRONG_YEAR = "Wrong birth year";
	private static final int CURRENT_YEAR = Calendar.getInstance().get(
			Calendar.YEAR);

	public Model() {
		super();
	}

	@Override
	public void save(OutputStream os) throws IOException {
		new ObjectOutputStream(os).writeObject(this);
	}

	@Override
	public void load(InputStream is) throws IOException, ClassNotFoundException {
		@SuppressWarnings("unchecked")
		HashSet<Person> h = (HashSet<Person>) new ObjectInputStream(is)
				.readObject();
		this.clear();
		this.addAll(h);
	}

	@Override
	public void add(String name, String surname, String code, int birthYear,
			boolean male) throws DataIncorrectException {
		String message = null;
		if (name == null || name.length() == 0) {
			message = WRONG_NAME;
		}
		if (surname == null || surname.length() == 0) {
			message = WRONG_SURNAME;
		}
		if (code == null || code.length() < 10) {
			message = WRONG_CODE;
		}
		if (birthYear < 1900 || birthYear > CURRENT_YEAR) {
			message = WRONG_YEAR;
		}
		if (message == null) {
			this.add(new Person(name, surname, code, birthYear, male));
			return;
		}
		throw new DataIncorrectException(message);
	}
}
