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
	
	@Test
	public void invokeBooleanGetterInConditional() throws Exception {
		final String template = "Hello, <person.firstname> <person.surname>!<if (person.nameIsPietro)> What a beatuful name!<endif>";
		final ST st = new ST(template);
		st.add("person", new Person("Pietro", "Martinelli"));
		assertEquals("Hello, Pietro Martinelli! What a beatuful name!", st.render());
	}
}
