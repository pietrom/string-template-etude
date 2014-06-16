package org.amicofragile.etude.st;

public class Person {
	private final String firstname;
	private final String surname;

	public Person(String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
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
}
