package org.amicofragile.etude.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class GroupInheritanceTest {
	@Test
	public void inheritanceThroughImport() throws Exception {
		final STGroup group = StringTemplateTestHelper.loadGroupFromResource("/inheritance/child.stg");
		final ST st = group.getInstanceOf("hello");
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
	
	@Test
	public void templateMethod() throws Exception {
		final STGroup group = StringTemplateTestHelper.loadGroupFromResource("/inheritance/child.stg");
		final ST st = group.getInstanceOf("hello2");
		st.add("name", "World");
		assertEquals("Hello, [World]!", st.render());
	}
}
