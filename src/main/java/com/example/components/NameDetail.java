package com.example.components;

import com.example.model.Person;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import er.extensions.components.ERXComponent;

public class NameDetail extends ERXComponent {
	private static final long serialVersionUID = 1L;

	public Person selectedPerson;
	public Main mainPage;

	public NameDetail(WOContext context) {
		super(context);
	}

	public WOActionResults backToMain() {
		return mainPage;
	}
}