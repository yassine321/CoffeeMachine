package com.lacombe.test.business;

import com.lacombe.test.model.Drinks;
import com.lacombe.test.model.Order;

/**
 * The CommandReceiver is the class that receives the customer command,
 * translate it, and send it to the drink maked
 * 
 * 
 * @author Lenovo
 *
 */
public class CommandReceiver {

	public static void main(String[] args) {
		int sugar = 2;
		float insertedMoney = 2f;
		Order order = new Order(Drinks.C, sugar, insertedMoney);
		CommandReceiver drinkMaker = new CommandReceiver();
		drinkMaker.takeOrder(order);
	}

	/**
	 * Method used to take an order and send a command to the DrinkMaker
	 * 
	 * @param order: the customer order
	 * @return a command that follow the DrinkMaker protocol
	 */
	public String takeOrder(Order order) {
		float change = order.getAddedMoney() - order.getDrink().getPrice();
		if (change >= 0) {
			return makeDrinkCommandConstructor(order);
		} else {
			return "m:" + order.getDrink().getDrinkName() + " price is " + order.getDrink().getPrice()
					+ "€, please add " + -change + "€";

		}
	}

	/**
	 * Method used to construct the command of making a drink, following DrinkMaker
	 * protocola
	 * 
	 * @param order
	 * @return
	 */
	private String makeDrinkCommandConstructor(Order order) {
		StringBuilder sb = new StringBuilder(order.getDrink() + ":");
		if (order.getSugar() > 0) {
			sb.append(order.getSugar() + ":0");
		} else {
			sb.append(":");
		}
		return sb.toString();
	}

}
