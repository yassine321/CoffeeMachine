package com.lacombe.test.model;

/**
 * Enum class representing the different drinks served by the machine
 * 
 * @author Lenovo
 *
 */
public enum Drinks {
	C("COFFEE", 0.6f), H("Chocolate", 0.5f), T("Tea", 0.4f), O("Orange Juice", 0.6f);

	private final String drinkName;
	private final float price;

	Drinks(String name, float price) {
		this.drinkName = name;
		this.price = price;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public float getPrice() {
		return price;
	}

}
