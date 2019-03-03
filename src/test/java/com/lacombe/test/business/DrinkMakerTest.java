package com.lacombe.test.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.lacombe.test.business.interfaces.BeverageQuantityChecker;
import com.lacombe.test.business.interfaces.EmailNotifier;
import com.lacombe.test.model.Drinks;
import com.lacombe.test.model.Order;

@RunWith(MockitoJUnitRunner.class)
public class DrinkMakerTest {

	CoffeeMachine coffeeMachine = new CoffeeMachine();
	private Order order;
	@Mock
	BeverageQuantityChecker quantityChecker;
	@Mock
	EmailNotifier notifier;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * order 1 Tea with 1 sugar and enough money
	 */
	@Test
	public void teaWith1Sugar() {
		order = new Order(Drinks.T, 1, 1f);
		assertEquals("Testing command protocol when commanding Tea with 1 sugar", "T:1:0",
				coffeeMachine.takeOrder(order));
	}

	/**
	 * order 1 chocolate without sugar and enough money
	 */
	@Test
	public void chocolateWithoutSugar() {
		order = new Order(Drinks.H, 0, 1f);
		assertEquals("Testing command protocol when commanding Chocolat without sugar", "H::",
				coffeeMachine.takeOrder(order));
	}

	/**
	 * order 1 Coffee with 2 sugars and enough money
	 */
	@Test
	public void coffeeWith2Sugar() {
		order = new Order(Drinks.C, 2, 1f);
		assertEquals("Testing command protocol when commanding Coffe  with 2 sugars", "C:2:0",
				coffeeMachine.takeOrder(order));
	}

	/**
	 * Order 1 Tea with 1 sugar, and inserting 0.2€
	 */
	@Test
	public void teaNotenoughMoney() {
		order = new Order(Drinks.T, 1, 0.2f);
		assertEquals("m:Tea price is 0.4€, please add 0.2€", coffeeMachine.takeOrder(order));
	}

	/**
	 * Test order of a ExtraCoffee with 1 sugar, enough money,
	 */
	@Test
	public void extraHotCoffee() {
		order = new Order(Drinks.C, 1, 1f, true);
		assertEquals("Ch:1:0", coffeeMachine.takeOrder(order));
	}

	/**
	 * Order Orange juice without sugar and enough money
	 */
	@Test
	public void orangeJuiceNoSugar() {
		order = new Order(Drinks.O, 0, 1f);
		assertEquals("O::", coffeeMachine.takeOrder(order));
	}

	/**
	 *
	 * Chocolate
	 */
	@Test
	public void report() {

		order = new Order(Drinks.O, 0, 1f);
		coffeeMachine.makeDrink(order);
		coffeeMachine.makeDrink(order);
		order = new Order(Drinks.T, 0, 1f);
		coffeeMachine.makeDrink(order);
		coffeeMachine.makeDrink(order);
		String report = new Repporting().generateReport();
		assertEquals("Orange Juice: 2\nTea: 2\nCoffee: 0\nChocolate: 0", report);
	}

	@Test
	public void shortageTest() {
		when(quantityChecker.isEmpty(Drinks.O)).thenReturn(false);
		order = new Order(Drinks.O, 0, 1f);
		assertEquals("m:shortage in resources", coffeeMachine.makeDrink(order));

	}
}
