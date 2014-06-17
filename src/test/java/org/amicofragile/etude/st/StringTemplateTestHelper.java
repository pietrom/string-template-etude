package org.amicofragile.etude.st;

import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class StringTemplateTestHelper {
	public static STGroup loadGroupFromResource(String resource) {
		return loadGroupFromResource(resource, '<', '>');
	}
	
	public static STGroup loadGroupFromResource(String resource, char left, char right) {
		final STGroup group = new STGroupFile(StringTemplateTestHelper.class.getResource(resource), "UTF-8", left, right);
		return group;
	}
}
