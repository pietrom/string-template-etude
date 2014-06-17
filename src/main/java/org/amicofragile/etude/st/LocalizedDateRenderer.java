package org.amicofragile.etude.st;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.stringtemplate.v4.AttributeRenderer;

public class LocalizedDateRenderer implements AttributeRenderer {
	public String toString(Object o, String formatString, Locale locale) {
		return new SimpleDateFormat(formatString, locale).format((Date)o);
	}
}
