package com.lacombe.test.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lacombe.test.model.Drinks;
import com.lacombe.test.model.Order;

public class DrinkMakerTest {

	CommandReceiver drinkMaker = new CommandReceiver();
	private Order order;

	@Test
	public void teaWith1Sugar() {
		order = new Order(Drinks.T, 1);
		assertEquals("Testing command protocol when commanding Tea with 1 sugar", "T:1:0",
				drinkMaker.takeCommand(order));
	}

	@Test
	public void chocolateWithoutSugar() {
		order = new Order(Drinks.H, 0);
		assertEquals("Testing command protocol when commanding Chocolat without sugar", "H::",
				drinkMaker.takeCommand(order));
	}

	@Test
	public void coffeeWith2Sugar() {
		order = new Order(Drinks.C, 2);
		assertEquals("Testing command protocol when commanding Coffe  with 2 sugars", "C:2:0",
				drinkMaker.takeCommand(order));
	}

}
