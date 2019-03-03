package com.lacombe.test.business.interfaces;

import com.lacombe.test.model.Drinks;

public interface EmailNotifier {
	void notifyMissingDrink(Drinks drink);
}
