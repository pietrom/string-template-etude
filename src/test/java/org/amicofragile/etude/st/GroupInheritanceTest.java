package org.amicofragile.etude.st;

import static org.junit.Assert.*;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class GroupInheritanceTest {
	@Test
	public void inheritanceThroughImport() throws Exception {
		final STGroup group = new STGroupFile(getClass().getResource("/inheritance/child.stg"), "UTF-8", '<', '>');
		final ST st = group.getInstanceOf("hello");
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
	
	@Test
	public void templateMethod() throws Exception {
		final STGroup group = new STGroupFile(getClass().getResource("/inheritance/child.stg"), "UTF-8", '<', '>');
		final ST st = group.getInstanceOf("hello2");
		st.add("name", "World");
		assertEquals("Hello, [World]!", st.render());
	}
}
