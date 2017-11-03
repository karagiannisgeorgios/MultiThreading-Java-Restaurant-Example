package mvcModel;

import java.util.HashMap;

public class OrderList {

	// attribute
	private static ReadOrders ro = new ReadOrders();
	private static GenerateRandomOrders randOr = new GenerateRandomOrders();

	// Return Readable HashMap per Id
	public static HashMap<Integer, Order> getHashMapListOfOrdersPerId() {
		
		return ro.getFileOrdersCollection();
	}

	// Return RandomGenerated HashMap per Id
	public static HashMap<Integer, Order> getRandomHashMapListOfOrdersPerId() {
		return randOr.getRandomOrders();
	}
}
