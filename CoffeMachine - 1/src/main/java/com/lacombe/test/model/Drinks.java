package com.lacombe.test.model;

/**
 * Enum class representing the different drinks served by the machine
 * 
 * @author Lenovo
 *
 */
public enum Drinks {
	C("COFFEE"), H("Chocolate"), T("Tea");

	private final String drinkName;

	Drinks(String name) {
		this.drinkName = name;
	}

	public String getDrinkName() {
		return drinkName;
	}

}
