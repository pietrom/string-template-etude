package org.amicofragile.etude.st;

public class Person {
	private final String firstname;
	private final String surname;
	private final String position;

	public Person(String firstname, String surname) {
		this(firstname, surname, null);
	}
	
	public Person(String firstname, String surname, String position) {
		this.firstname = firstname;
		this.surname = surname;
		this.position = position;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}
	
	public Boolean getNameIsPietro() {
		return "Pietro".equals(firstname);
	}
	
	public String getPosition() {
		return position;
	}
}
