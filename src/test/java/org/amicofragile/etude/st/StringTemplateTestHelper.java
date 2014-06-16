package org.amicofragile.etude.st;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class StringTemplateTestHelper {
	public static STGroup loadGroupFromResource(String resource) {
		final STGroup group = new STGroupFile(StringTemplateTestHelper.class.getResource(resource), "UTF-8", '<', '>');
		return group;
	}
}
