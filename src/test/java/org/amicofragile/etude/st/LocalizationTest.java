package org.amicofragile.etude.st;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

public class LocalizationTest {
	@Test
	public void localizeLabelsFromResourceBundle() throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/labels");
		STGroup group = new STGroupString("page", "page(labels) ::= \"<html><head><title>{labels.title}</title></head><body>{labels.body}</body></html>\"", '{', '}');
		group.registerModelAdaptor(ResourceBundle.class, new ResourceBundleModelAdaptor());
		ST st = group.getInstanceOf("page");
		st.add("labels", bundle);
		System.out.println(st.render());
		assertTrue(st.render().contains("<title>Page title</title></head><body>Page body</body>"));
	}
	
	@Test
	public void localizeDateRendering() throws Exception {
		ResourceBundle bundle = ResourceBundle.getBundle("i18n/labels");
		final String groupString = 
				"date(labels, now) ::= <<\n" + 
						"<labels.date>: <now; format=\"EEE dd MMMM yyyy\">\n" +
						">>\n";
		STGroup group = new STGroupString(groupString);
		group.registerModelAdaptor(ResourceBundle.class, new ResourceBundleModelAdaptor());
		group.registerRenderer(Date.class, new LocalizedDateRenderer());
		ST st = group.getInstanceOf("date");
		st.add("labels", bundle);
		st.add("now", new Date(0));
		assertEquals("Current date: gio 01 gennaio 1970", st.render(Locale.ITALY));
		assertEquals("Current date: Thu 01 January 1970", st.render(Locale.ENGLISH));
	}
}
