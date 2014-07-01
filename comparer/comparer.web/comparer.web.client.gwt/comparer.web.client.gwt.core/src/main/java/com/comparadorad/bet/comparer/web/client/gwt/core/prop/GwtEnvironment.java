package com.comparadorad.bet.comparer.web.client.gwt.core.prop;

import com.google.gwt.i18n.client.Constants;

public interface GwtEnvironment extends Constants{

	@DefaultStringValue("betcompara")
	@Key("environment")
	String environment();
	
}
