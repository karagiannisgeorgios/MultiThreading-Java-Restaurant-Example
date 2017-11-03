package mvcModel;

public class Bill {

	// Method Counts and Prints the Bill per Table
	public static String getPrintedBill(int aTableID) {

		String printedBill = "";
		double sumOfDish = 0;
		double sumOfAllDishes = 0;
		printedBill += String.format("%55s", "BILL") + "\n" + String.format("%55s", "===========");
		printedBill += String.format("%60s",
				"\n" + "                                                 Table " + aTableID) + "\n" + "\n";
		try {
			for (Order order : Restaurant_Model.getFinalHashMapOfOrders().get(aTableID)) {
				sumOfDish = order.getQuantity() * MenuList.getHashMapDishesAndPrices().get(order.getDishName());
				sumOfAllDishes += sumOfDish;
				sumOfDish = Math.round(sumOfDish * 1e2) / 1e2;

				printedBill += String.format("\n" + "%25s%10s%10s%2s", order.getDishName(),
						order.getQuantity() + "     *", MenuList.getHashMapDishesAndPrices().get(order.getDishName()),
						" $  =  " + sumOfDish + " $");

			}
		} catch (Exception e) {
			printedBill = "This Table was not used today";

		}

		printedBill += "\n";
		printedBill += String.format("\n" + "%58s",
				"Total without Tax " + Math.round(sumOfAllDishes * 1e2) / 1e2 + " $");
		printedBill += String.format("\n" + "%58s", "Tax  " + Math.round(sumOfAllDishes * 0.23 * 1e2) / 1e2 + " $");
		printedBill += String.format("\n" + "%58s",
				"Total Bill " + Math.round(sumOfAllDishes * 1.23 * 1e2) / 1e2 + " $");
		double sum = 0;
		return printedBill;
	}

}
