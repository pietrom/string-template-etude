package org.amicofragile.etude.st;

import java.util.LinkedList;
import java.util.List;

public class Select {
	private final String name;
	private final List<Option> options;
	public Select(String name) {
		this.name = name;
		this.options = new LinkedList<Option>();
	}

	public String getName() {
		return name;
	}
	
	public List<Option> getOptions() {
		return options;
	}

	public void addOption(Option option) {
		options.add(option);
	}
}
