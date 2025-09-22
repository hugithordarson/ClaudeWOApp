package com.example.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class NameDetail extends WOComponent {
	private static final long serialVersionUID = 1L;

	public String selectedName;

	public NameDetail(WOContext context) {
		super(context);
	}

	public WOActionResults backToMain() {
		return pageWithName(Main.class.getName());
	}
}