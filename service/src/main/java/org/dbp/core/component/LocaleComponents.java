package org.dbp.core.component;

import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class LocaleComponents {
	
	public Locale getLocale(){
		return Locale.getDefault();
	}
	
}
