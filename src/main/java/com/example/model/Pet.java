package com.example.model;

import org.apache.cayenne.CayenneDataObject;

public class Pet extends CayenneDataObject {
	private static final long serialVersionUID = 1L;

	public static final String NAME_PROPERTY = "name";
	public static final String PERSON_PROPERTY = "person";

	public String getName() {
		return (String) readProperty(NAME_PROPERTY);
	}

	public void setName(String name) {
		writeProperty(NAME_PROPERTY, name);
	}

	public Person getPerson() {
		return (Person) readProperty(PERSON_PROPERTY);
	}

	public void setPerson(Person person) {
		writeProperty(PERSON_PROPERTY, person);
	}

	public String toString() {
		return getName();
	}
}