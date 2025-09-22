package com.example.model;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;

public class Person extends CayenneDataObject {
	private static final long serialVersionUID = 1L;

	public static final String NAME_PROPERTY = "name";
	public static final String ADDRESS_PROPERTY = "address";
	public static final String PHONE_NUMBER_PROPERTY = "phoneNumber";
	public static final String PETS_PROPERTY = "pets";

	public String getName() {
		return (String) readProperty(NAME_PROPERTY);
	}

	public void setName(String name) {
		writeProperty(NAME_PROPERTY, name);
	}

	public String getAddress() {
		return (String) readProperty(ADDRESS_PROPERTY);
	}

	public void setAddress(String address) {
		writeProperty(ADDRESS_PROPERTY, address);
	}

	public String getPhoneNumber() {
		return (String) readProperty(PHONE_NUMBER_PROPERTY);
	}

	public void setPhoneNumber(String phoneNumber) {
		writeProperty(PHONE_NUMBER_PROPERTY, phoneNumber);
	}

	@SuppressWarnings("unchecked")
	public List<Pet> getPets() {
		return (List<Pet>) readProperty(PETS_PROPERTY);
	}

	public void addToPets(Pet pet) {
		addToManyTarget(PETS_PROPERTY, pet, true);
	}

	public void removeFromPets(Pet pet) {
		removeToManyTarget(PETS_PROPERTY, pet, true);
	}

	public String toString() {
		return getName();
	}
}