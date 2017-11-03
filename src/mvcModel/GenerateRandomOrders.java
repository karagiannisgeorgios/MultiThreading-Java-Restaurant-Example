package mvcModel;

import java.util.HashMap;
import java.util.Random;

public class GenerateRandomOrders {

	// attribute
	private HashMap<Integer, Order> randomOrders = new HashMap<Integer, Order>();

	public GenerateRandomOrders() {
		for (int i = 1; i < 50; i++) {
			Random rn = new Random();
			int randomTableId = rn.nextInt(10) + 1;

			String randomDishName = "";
			int size = MenuList.getHashSetStringNames().size();
			int item = new Random().nextInt(size);
			int m = 0;
			for (String name : MenuList.getHashSetStringNames()) {
				if (m == item)
					randomDishName = name;
				m = m + 1;
			}

			Random rno = new Random();
			int randomquantity = rno.nextInt(5) + 1;

			Order eachOrder = new Order(randomTableId, randomDishName, randomquantity);
			randomOrders.put(i, eachOrder);

		}
	}

	public HashMap<Integer, Order> getRandomOrders() {

		return randomOrders;

	}
}
