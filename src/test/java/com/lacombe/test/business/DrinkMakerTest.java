package com.lacombe.test.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lacombe.test.model.Drinks;
import com.lacombe.test.model.Order;

public class DrinkMakerTest {

	CommandReceiver commandReceiver = new CommandReceiver();
	private Order order;

	/**
	 * order 1 Tea with 1 sugar and enought money
	 */
	@Test
	public void teaWith1Sugar() {
		order = new Order(Drinks.T, 1, 1f);
		assertEquals("Testing command protocol when commanding Tea with 1 sugar", "T:1:0",
				commandReceiver.takeOrder(order));
	}

	/**
	 * order 1 chocolate without sugar and enought money
	 */
	@Test
	public void chocolateWithoutSugar() {
		order = new Order(Drinks.H, 0, 1f);
		assertEquals("Testing command protocol when commanding Chocolat without sugar", "H::",
				commandReceiver.takeOrder(order));
	}

	/**
	 * order 1 Coffee with 2 sugars and enought money
	 */
	@Test
	public void coffeeWith2Sugar() {
		order = new Order(Drinks.C, 2, 1f);
		assertEquals("Testing command protocol when commanding Coffe  with 2 sugars", "C:2:0",
				commandReceiver.takeOrder(order));
	}

	/**
	 * Order 1 Tea with 1 sugar, and inserting 0.2€
	 */
	@Test
	public void teaNotEnoughtMoney() {
		order = new Order(Drinks.T, 1, 0.2f);
		assertEquals("m:Tea price is 0.4€, please add 0.2€", commandReceiver.takeOrder(order));
	}
}
