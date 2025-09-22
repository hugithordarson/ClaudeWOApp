package com.example.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class PageWrapper extends WOComponent {
	private static final long serialVersionUID = 1L;

	public String title = "MyWebObjectsApp";

	public PageWrapper(WOContext context) {
		super(context);
	}

	public boolean synchronizesVariablesWithBindings() {
		return false;
	}

	public boolean isStateless() {
		return true;
	}
}