package org.amicofragile.etude.st;

import org.junit.Test;

import static org.junit.Assert.*;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;
import org.stringtemplate.v4.StringRenderer;

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
	
	@Test
	public void useStringRenderer() throws Exception {
		final String groupString = 
				"pul(name) ::= <<\n" + 
						"<name>;<name; format=\"upper\">;<name; format=\"lower\">\n" +
						">>\n";
		final STGroup group = new STGroupString(groupString);
		group.registerRenderer(String.class, new StringRenderer());
		final ST st = group.getInstanceOf("pul");
		st.add("name", "World");
		assertEquals("World;WORLD;world", st.render());
	}
}
