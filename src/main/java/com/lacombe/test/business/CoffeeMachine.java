package com.lacombe.test.business;

import com.lacombe.test.business.interfaces.BeverageQuantityChecker;
import com.lacombe.test.business.interfaces.EmailNotifier;
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
public class CoffeeMachine {
	/**
	 * the amount of the minl in the machine reserve we assume that one order need 1
	 * unit of milk we asume also that only Chocolate that uses milk
	 */
	private int milkReserve;

	/**
	 * the amount of water in the machine reserve/ we assume that one order need 1
	 * unit of water we asumes also that Coffee, Orange juice (hhh) and Tea use
	 * water
	 */
	private int waterReserve;

	private BeverageQuantityChecker quantityChecker;
	private EmailNotifier notifier;

	public CoffeeMachine() {
		super();
	}

	public CoffeeMachine(int milkReserve, int waterReserve) {
		super();
		this.milkReserve = milkReserve;
		this.waterReserve = waterReserve;
	}

	private DrinkMaker drinkMaker = new DrinkMaker();

	/**
	 * 
	 * !!!! For the 5th iteration we return the command to be sent, to run Tests
	 * method used to make a drink
	 * 
	 * @param order the customer order
	 */
	public String makeDrink(Order order) {
		String command;
		if (quantityChecker.isEmpty(order.getDrink())) {
			notifier.notifyMissingDrink(order.getDrink());
			command = "m:shortage in resources";
		} else {
			command = takeOrder(order);
			order.getDrink().counter++;
			consumeResources(order.getDrink());
		}
		return command;
	}

	private void consumeResources(Drinks drink) {
		if (drink == Drinks.H) {
			milkReserve--;
		} else {
			waterReserve--;
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
