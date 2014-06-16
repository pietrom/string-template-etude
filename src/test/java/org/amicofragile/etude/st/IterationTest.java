package org.amicofragile.etude.st;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.stringtemplate.v4.ST;

public class IterationTest {
	@Test
	public void iterateAndRender() throws Exception {
		final String template = "Hello, <persons; separator=\", \">!";
		final ST st = new ST(template);
		st.add("persons", new String[] {"Qui", "Quo", "Qua"});
		assertEquals("Hello, Qui, Quo, Qua!", st.render());
	}
	
	@Test
	public void iterateAndApplyAnonymousTemplate() throws Exception {
		final String template = "Hello, <persons:{p | <p.firstname>}; separator=\", \">!";
		final ST st = new ST(template);
		final List<Person> persons = new LinkedList<Person>();
		persons.add(new Person("Qui", "Duck"));
		persons.add(new Person("Quo", "Duck"));
		persons.add(new Person("Qua", "Duck"));
		st.add("persons", persons);
		assertEquals("Hello, Qui, Quo, Qua!", st.render());
	}
}
