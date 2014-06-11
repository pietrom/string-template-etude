package org.amicofragile.etude.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

public class InlineTemplateTest {
	@Test
	public void helloWorld() throws Exception {
		final String template = "Hello, <name>!";
		final ST st = new ST(template);
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
	
	@Test
	public void groupSample() throws Exception {
		final String groupString = 
				"lc(name) ::= <<\n" + 
						"hello, <name>!\n" +
						">>\n" + 
				"uc(name) ::= <<\n" +
						"HELLO, <name>!\n" + 
				">>\n";
		final STGroup group = new STGroupString(groupString);
		final ST lc = group.getInstanceOf("lc");
		lc.add("name", "World");
		assertEquals("hello, World!", lc.render());
		final ST uc = group.getInstanceOf("uc");
		uc.add("name", "World");
		assertEquals("HELLO, World!", uc.render());
	}
}
