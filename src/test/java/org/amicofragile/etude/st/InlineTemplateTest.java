package org.amicofragile.etude.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.stringtemplate.v4.ST;

public class InlineTemplateTest {
	@Test
	public void helloWorld() throws Exception {
		final String template = "Hello, <name>!";
		final ST st = new ST(template);
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
}
