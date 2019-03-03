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
	/**
	 * The Amount of money inserted in the machine
	 */
	private float insertedMoney;

	public Order(Drinks drink, int sugar) {
		super();
		this.drink = drink;
		this.sugar = sugar;
	}

	public Order(Drinks drink, int sugar, float addedMoney) {
		this(drink, sugar);
		this.insertedMoney = addedMoney;
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

	public float getAddedMoney() {
		return insertedMoney;
	}

	public void setAddedMoney(float addedMoney) {
		this.insertedMoney = addedMoney;
	}

}
