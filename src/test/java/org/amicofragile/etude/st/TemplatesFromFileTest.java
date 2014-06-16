package org.amicofragile.etude.st;

import org.junit.Test;

import static org.junit.Assert.*;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class TemplatesFromFileTest {
	@Test
	public void helloWorld() throws Exception {
		final STGroup group =StringTemplateTestHelper.loadGroupFromResource("/hello.stg");
		final ST st = group.getInstanceOf("hello");
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
	
	@Test
	public void customDelimiters() throws Exception {
		final STGroup group =StringTemplateTestHelper.loadGroupFromResource("/hello-cd.stg");
		final ST st = group.getInstanceOf("hello");
		st.add("name", "World");
		assertEquals("Hello, World!", st.render());
	}
}
