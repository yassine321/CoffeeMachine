package com.lacombe.test.business;

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

	private DrinkMaker drinkMaker = new DrinkMaker();

	/**
	 * method used to make a drink
	 * 
	 * @param order the customer order
	 */
	public void makeDrink(Order order) {
		String command = takeOrder(order);
		if (drinkMaker.makeDrink(command)) {
			order.getDrink().counter++;
		}

	}

	/**
	 * Method used to take an order and send a command to the DrinkMaker
	 * 
	 * @param order: the customer order
	 * @return a command that follow the DrinkMaker protocol
	 */
	public String takeOrder(Order order) {
		float change = order.getInsertedMoney() - order.getDrink().getPrice();
		String Command;
		if (change >= 0) {
			Command = makeDrinkCommandConstructor(order);
		} else {
			Command = "m:" + order.getDrink().getDrinkName() + " price is " + order.getDrink().getPrice()
					+ "€, please add " + -change + "€";

		}
		return Command;
	}

	/**
	 * Method used to construct the command of making a drink, following DrinkMaker
	 * protocola
	 * 
	 * @param order
	 * @return
	 */
	private String makeDrinkCommandConstructor(Order order) {
		StringBuilder sb = new StringBuilder(order.getDrink().toString());
		if (order.isExtraHot()) {
			sb.append("h");
		}
		sb.append(":");
		if (order.getSugar() > 0) {
			sb.append(order.getSugar() + ":0");
		} else {
			sb.append(":");
		}
		return sb.toString();
	}

}
