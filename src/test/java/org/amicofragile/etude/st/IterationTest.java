package org.amicofragile.etude.st;

import static org.junit.Assert.*;

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
}
