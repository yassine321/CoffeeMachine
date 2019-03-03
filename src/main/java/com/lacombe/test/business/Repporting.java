package com.lacombe.test.business;

import com.lacombe.test.model.Drinks;

public class Repporting {
	/**
	 * class used to display report
	 * 
	 * @return it return the report as a string
	 */
	public String generateReport() {
		StringBuilder sb = new StringBuilder();
		sb.append("Orange Juice: " + Drinks.O.getCounter() + "\n");
		sb.append("Tea: " + Drinks.T.getCounter() + "\n");
		sb.append("Coffee: " + Drinks.C.getCounter() + "\n");
		sb.append("Chocolate: " + Drinks.H.getCounter());
		return sb.toString();
	}

	/**
	 * method crated juste to follow the instructions : display the report in the
	 * console
	 */
	public void displayReport() {
		System.out.println(generateReport());
	}
}
