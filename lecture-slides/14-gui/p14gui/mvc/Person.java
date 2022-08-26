package it.unibo.apice.oop.p15gui.mvc;

public class Person implements java.io.Serializable{
	
	private static final long serialVersionUID = -6507009699496712389L;
	
	private String name;
	private String surname;
	private String code;
	private int birthYear;
	private boolean male;
	
	public Person(String name, String surname, String code, int birthYear, boolean male) {
		super();
		this.name = name;
		this.surname = surname;
		this.code = code;
		this.birthYear = birthYear;
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getCode() {
		return code;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public boolean isMale() {
		return male;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
	
}
