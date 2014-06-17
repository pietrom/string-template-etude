package org.amicofragile.etude.st;

import java.util.ResourceBundle;

import org.stringtemplate.v4.Interpreter;
import org.stringtemplate.v4.ModelAdaptor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.misc.STNoSuchPropertyException;

public class ResourceBundleModelAdaptor implements ModelAdaptor {

	public Object getProperty(Interpreter interp, ST self, Object o, Object property, String propertyName) throws STNoSuchPropertyException {
		ResourceBundle bundle = (ResourceBundle) o;
		return bundle.getString(propertyName);
	}
}
