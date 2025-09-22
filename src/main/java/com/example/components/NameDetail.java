package com.example.components;

import com.example.model.Person;
import com.example.model.Pet;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import er.extensions.components.ERXComponent;

public class NameDetail extends ERXComponent {
	private static final long serialVersionUID = 1L;

	public Person selectedPerson;
	public Main mainPage;
	public String petNameInput;
	public Pet currentPet;

	public NameDetail(WOContext context) {
		super(context);
	}

	public WOActionResults backToMain() {
		return mainPage;
	}

	public WOActionResults addPet() {
		if (petNameInput != null && !petNameInput.trim().isEmpty() && selectedPerson != null) {
			Pet pet = selectedPerson.getObjectContext().newObject(Pet.class);
			pet.setName(petNameInput.trim());
			pet.setPerson(selectedPerson);
			selectedPerson.getObjectContext().commitChanges();

			// Refresh the person object to update the pets relationship
			selectedPerson.getObjectContext().invalidateObjects(selectedPerson);

			petNameInput = "";
		}
		return null;
	}

	public WOActionResults deletePet() {
		if (currentPet != null && selectedPerson != null) {
			selectedPerson.getObjectContext().deleteObjects(currentPet);
			selectedPerson.getObjectContext().commitChanges();

			// Refresh the person object to update the pets relationship
			selectedPerson.getObjectContext().invalidateObjects(selectedPerson);
		}
		return null;
	}
}