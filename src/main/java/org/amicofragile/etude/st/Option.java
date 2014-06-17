package org.amicofragile.etude.st;

public class Option {
	private final String value;
	private final String label;

	public Option(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
}
