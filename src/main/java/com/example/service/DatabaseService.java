package com.example.service;

import java.util.List;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;

import com.example.model.Person;
import com.example.model.Pet;

public class DatabaseService {
	private static DatabaseService instance;
	private ServerRuntime cayenneRuntime;

	private DatabaseService() {
		cayenneRuntime = ServerRuntime.builder()
			.addConfig("cayenne-project.xml")
			.build();
	}

	public static synchronized DatabaseService getInstance() {
		if (instance == null) {
			instance = new DatabaseService();
		}
		return instance;
	}

	public ObjectContext getObjectContext() {
		return cayenneRuntime.newContext();
	}

	public List<Person> getAllPersons() {
		ObjectContext context = getObjectContext();
		return ObjectSelect.query(Person.class).select(context);
	}

	public Person createPerson(String name, String address, String phoneNumber) {
		ObjectContext context = getObjectContext();
		Person person = context.newObject(Person.class);
		person.setName(name);
		person.setAddress(address);
		person.setPhoneNumber(phoneNumber);
		context.commitChanges();
		return person;
	}

	public void deleteAllData() {
		ObjectContext context = getObjectContext();

		// Delete all pets first (due to foreign key constraints)
		List<Pet> allPets = ObjectSelect.query(Pet.class).select(context);
		context.deleteObjects(allPets);

		// Then delete all persons
		List<Person> allPersons = ObjectSelect.query(Person.class).select(context);
		context.deleteObjects(allPersons);

		context.commitChanges();
	}

	public void shutdown() {
		if (cayenneRuntime != null) {
			cayenneRuntime.shutdown();
		}
	}
}