package org.amicofragile.etude.st;

import java.util.ResourceBundle;

import org.junit.Test;

import static org.junit.Assert.*;

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
}
