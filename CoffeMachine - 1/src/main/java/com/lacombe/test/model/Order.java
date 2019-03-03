package com.lacombe.test.model;

/**
 * Order class : used to represent a customer order
 * 
 * @author RAKIBI
 * 
 */
public class Order {

	/**
	 * the drink chosen by the customer
	 */
	private Drinks drink;
	/**
	 * The amount of suger
	 */
	private int sugar;

	public Order(Drinks drink, int sugar) {
		super();
		this.drink = drink;
		this.sugar = sugar;
	}

	public Order() {
		super();
	}

	public Drinks getDrink() {
		return drink;
	}

	public void setDrink(Drinks drink) {
		this.drink = drink;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

}
