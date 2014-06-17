package org.amicofragile.etude.st;

import static org.junit.Assert.*;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public class MarkupTest {
	@Test
	public void renderSelectWithProvidedOptions() throws Exception {
		Select s = new Select("theSelect");
		s.addOption(new Option("1", "Uno"));
		s.addOption(new Option("2", "Due"));
		s.addOption(new Option("3", "Tre"));
		
		final STGroup group =StringTemplateTestHelper.loadGroupFromResource("/form.stg", '{', '}');
		final ST st = group.getInstanceOf("select");
		st.add("s", s);
		final String markup = st.render();
		System.out.println(markup);
		assertTrue(markup.contains("<select name=\"theSelect\">"));
		assertTrue(markup.contains("<option value=\"1\">Uno</option>"));
		assertTrue(markup.contains("<option value=\"3\">Tre</option>"));
	}
}
