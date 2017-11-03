package mvcModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ReadOrders {
	// My main Data Structure for read Orders
	private HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
	// Error line problem counter
	private int errorLineOther = 1;
	private int errorLineTableId = 1;
	private int errorLineQuantity = 1;

	// Create HashSets of Orders per Table
	public ReadOrders() {

		//File ordersFile = new File("/PackageFiles/orders.txt");

		Scanner scannerOrders = null;
		scannerOrders = new Scanner(getClass().getResourceAsStream("/PackageFiles/orders.txt"));

		while (scannerOrders.hasNextLine()) {

			String inputLine = scannerOrders.nextLine();
			String OrderParts[] = inputLine.split(",");

			// my variables before try and catch
			String ordTableId = "";
			int orderTableId = 0;
			String orderDishName = "";
			String ordQuantity = "";
			int orderQuantity = 0;

			// try out of bounds error which catches it in the end
			try {
				// variable which will count on which line our error is
				errorLineOther++;

				ordTableId = OrderParts[0];
				ordTableId = ordTableId.trim();

				try {
					orderTableId = Integer.parseInt(ordTableId);

					// counter for error line
					errorLineTableId++;
					if ((orderTableId<1) || (orderTableId>10) )
					{
						throw new invalidLineTableId( errorLineTableId-1);
					}
				} 
				
					catch (invalidLineTableId e) {
				//	System.out.println("Wrong Input in Line " + errorLineTableId + " in the Orders File !" + "\n"
				//			+ "Please Check that you have given a value Table Number");
					System.out.println(e.getMessage());
					System.exit(0);
				}

				orderDishName = OrderParts[1];
				ordQuantity = OrderParts[2];
				ordQuantity = ordQuantity.trim();
				try {
					orderQuantity = Integer.parseInt(ordQuantity);
					// errorline for Quantity
					errorLineQuantity++;
					
					if ((orderQuantity<1))
					{
						throw new invalidQuantity( errorLineTableId);
					}
					
				} catch (invalidQuantity e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}

				// Check if there is an appropriate number of tables given
				if (orderTableId > 10) {
					System.out.println("Sorry an order could not be achieved cause there is not a table with number: "
							+ orderTableId + " in the Restaurant");
				}

				// Check if the Order Dishes match the Menu dishes
				int f = 0;

				if ((MenuList.getHashSetStringNames().contains(orderDishName)) && f == 0) {

				} else {
					f++;
					System.out.println("Sorry the dish: " + orderDishName + " is not contained in the Menu");
					System.exit(0);
				}
				
				

				// Create Order
				Order eachOrder = new Order(orderTableId, orderDishName, orderQuantity);
				
				//Check if Order is duplicate
				for(Integer num: this.getFileOrdersCollection().keySet()){
					
					
					
				}
					
				orders.put(eachOrder.getId(), eachOrder);

			} catch (Exception e) {
				int errorLineOtherMinusOne = errorLineOther - 1;
				System.out.println("Problem in Line " + errorLineOtherMinusOne + " !" + "\n" + "Check your input again."
						+ "\n" + "Check if you haven’t forgotten any commas. ");
				System.exit(0);
			}

		}
		scannerOrders.close();

	}

	public HashMap<Integer, Order> getFileOrdersCollection() {
		return orders;
	}

}
