package org.amicofragile.etude.st;

import static org.junit.Assert.*;

import org.junit.Test;
import org.stringtemplate.v4.ST;

public class InvokingMethodsTest {
	@Test
	public void invokeGetter() throws Exception {
		final String template = "Hello, <person.firstname> <person.surname>!";
		final ST st = new ST(template);
		st.add("person", new Person("Pietro", "Martinelli"));
		assertEquals("Hello, Pietro Martinelli!", st.render());
	}
}
