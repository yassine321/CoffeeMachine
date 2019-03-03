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

	/**
	 * Attribute to specify if the drink, will be extra hot or not, for cold drink
	 * (like orange juice) this value is always false (see the setter)
	 */
	private boolean extraHot;

	public Order(Drinks drink, int sugar) {
		super();
		this.drink = drink;
		this.sugar = sugar;
	}

	public Order(Drinks drink, int sugar, float insertedMoney) {
		this(drink, sugar);
		this.insertedMoney = insertedMoney;
	}

	public Order(Drinks drink, int sugar, float insertedMoney, boolean extraHot) {
		this(drink, sugar, insertedMoney);
		this.extraHot = extraHot;
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

	public float getInsertedMoney() {
		return insertedMoney;
	}

	public void setInsertedMoney(float addedMoney) {
		this.insertedMoney = addedMoney;
	}

	public boolean isExtraHot() {
		return extraHot;
	}

	public void setExtraHot(boolean extraHot) {
		if (this.drink == Drinks.O) {
			this.extraHot = false;
		}
		this.extraHot = extraHot;
	}

}
