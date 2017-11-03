package mvcModel;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;

public class FrequencyReport {

	
	  // String of Frequency Report public static String
	 public static void getFrequencyReportInString() {
	 
	  HashSet<Order> freqRep = new HashSet<Order>(); String s = ""; for
	  (Integer Id : Restaurant_Model.getFinalHashMapOfOrders().keySet()) {
	  freqRep.addAll(Restaurant_Model.getFinalHashMapOfOrders().get(Id)); }
	  
	  s += ("FREQUENCY REPORT" + "\n" + "=================" + "\n"); for (Order
	 order : freqRep) s += "\n" + (String.format("%25s%10s",
	  order.getDishName(), order.getQuantity())) + "\n";  }
	 

	// String of Dishes Not Ordered
	public static String getStringDishesNotOrdered() {
		HashSet<String> allOrders = new HashSet<String>();
		String s = "";
		// Remove
		s += ("\n" + "DISHES NOT ORDERED" + "\n" + "===================" + "\n");

		allOrders.addAll(MenuList.getHashSetStringNames());
		allOrders.removeAll(Restaurant_Model.getAllStringNamesOfOrders());

		for (String dishName : allOrders)
			s += "\n" + dishName + "\n";
		return s;
	}

	public static void createFrequencyReport() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("Frequency_report.txt");
		writer.print(MenuList.getStringCatalog());
		writer.print(getStringDishesNotOrdered());
		writer.close();
	}

}
