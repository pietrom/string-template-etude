package org.amicofragile.etude.st;

import org.junit.Test;
import static org.junit.Assert.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class TemplatesFromFileTest {
	@Test
	public void helloWorld() throws Exception {
		final STGroup group = new STGroupFile(getClass().getResource("/hello.stg"), "UTF-8", '<', '>');
		final ST st = group.getInstanceOf("hello");
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
}
