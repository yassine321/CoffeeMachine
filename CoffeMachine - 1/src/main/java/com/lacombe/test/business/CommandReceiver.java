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
		Order order = new Order();
		order.setDrink(Drinks.C);
		order.setSugar(sugar);
		CommandReceiver drinkMaker = new CommandReceiver();
		drinkMaker.takeCommand(order);

	}

	/**
	 * 
	 * @param order: the customer order
	 * @return a command that follow the DrinkMaker protocol
	 */
	public String takeCommand(Order order) {
		StringBuilder sb = new StringBuilder();
		sb.append(order.getDrink() + ":");
		if (order.getSugar() > 0) {
			sb.append(order.getSugar() + ":0");
		} else {
			sb.append(":");
		}
		return sb.toString();
	}
}
