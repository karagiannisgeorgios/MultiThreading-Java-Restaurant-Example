package mvcModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;

import mvcView.Restaurant_View;

public class Restaurant_Model extends Observable {

	private LinkedList<Order> kitchenLinkedList = new LinkedList<Order>();
	private LinkedList<Order> hatchLinkedList = new LinkedList<Order>();
	private LinkedList<Order> finalLinkedList = new LinkedList<Order>();

	// Data Structures for the rest Program
	// HashMap with key the tableId and values a HashSet Of Orders
	private static HashMap<Integer, HashSet<Order>> hashMapOfOrders = new HashMap<Integer, HashSet<Order>>();
	private HashSet<Order> orderTable1 = new HashSet<Order>();
	private HashSet<Order> orderTable2 = new HashSet<Order>();
	private HashSet<Order> orderTable3 = new HashSet<Order>();
	private HashSet<Order> orderTable4 = new HashSet<Order>();
	private HashSet<Order> orderTable5 = new HashSet<Order>();
	private HashSet<Order> orderTable6 = new HashSet<Order>();
	private HashSet<Order> orderTable7 = new HashSet<Order>();
	private HashSet<Order> orderTable8 = new HashSet<Order>();
	private HashSet<Order> orderTable9 = new HashSet<Order>();
	private HashSet<Order> orderTable10 = new HashSet<Order>();
	// HashSet with all the String Names of Orders
	private static HashSet<String> allStringNamesOrders = new HashSet<String>();

	public static boolean kitchenFinished = false;
	public static boolean hatchFinished = false;

	
	Log log;
	private boolean weAreFinishedForToday;
	
	// Constructor
	public Restaurant_Model() {
		
		log= Log.getLogOblect();
		weAreFinishedForToday=false;
	}

	public void start() {

		fromOrdersToKitchen first = new fromOrdersToKitchen(this);
		Thread firstThread = new Thread(first);
		firstThread.start();

		fromKitchenToHatch second = new fromKitchenToHatch(this);
		Thread secondThread = new Thread(second);
		secondThread.start();

		fromHatchToTables third = new fromHatchToTables(this);
		Thread thirdThread = new Thread(third);
		thirdThread.start();

	}

	public String getKitchenListView() {
		String s = "";
		for (Order order : kitchenLinkedList)
			s += order.getOrderDetails();
		//Restaurant_View.startDisplayingtheOrders(s);
		return s;
	}

	public String getHatchListView() {
		String s = "";
		for (Order order : hatchLinkedList)
			s += order.getOrderDetails();
		//Restaurant_View.startDisplayingtheHatch(s);
		return s;
	}

	public void getTablesView() {
		String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
		s1 = "";
		s2 = "";
		s3 = "";
		s4 = "";
		s5 = "";
		s6 = "";
		s7 = "";
		s8 = "";
		s9 = "";
		s10 = "";
		for (Order order : finalLinkedList) {
			if (order.getTableId() == 1) {
				s1 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(1, s1);
				orderTable1.add(order);
				hashMapOfOrders.put(1, orderTable1);
			} else if (order.getTableId() == 2) {
				s2 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(2, s2);
				orderTable2.add(order);
				hashMapOfOrders.put(2, orderTable2);
			} else if (order.getTableId() == 3) {
				s3 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(3, s3);
				orderTable3.add(order);
				hashMapOfOrders.put(3, orderTable3);
			} else if (order.getTableId() == 4) {
				s4 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(4, s4);
				orderTable4.add(order);
				hashMapOfOrders.put(4, orderTable4);
			} else if (order.getTableId() == 5) {
				s5 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(5, s5);
				orderTable5.add(order);
				hashMapOfOrders.put(5, orderTable5);
			} else if (order.getTableId() == 6) {
				s6 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(6, s6);
				orderTable6.add(order);
				hashMapOfOrders.put(6, orderTable6);
			} else if (order.getTableId() == 7) {
				s7 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(7, s7);
				orderTable7.add(order);
				hashMapOfOrders.put(7, orderTable7);
			} else if (order.getTableId() == 8) {
				s8 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(8, s8);
				orderTable8.add(order);
				hashMapOfOrders.put(8, orderTable8);
			} else if (order.getTableId() == 9) {
				s9 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(9, s9);
				orderTable9.add(order);
				hashMapOfOrders.put(9, orderTable9);
			} else if (order.getTableId() == 10) {
				s10 += order.getOrderShortDetails();
				Restaurant_View.startDisplayingtheTables(10, s10);
				orderTable10.add(order);
				hashMapOfOrders.put(10, orderTable10);
			}

			allStringNamesOrders.add(order.getDishName());

		}
	}

	public synchronized void fromOrdersToKitchen(int i) {

		if (!Restaurant_View.getRandomOrders()){
			kitchenLinkedList.add(OrderList.getHashMapListOfOrdersPerId().get(i));
			log.addEntry("order ID : " + OrderList.getHashMapListOfOrdersPerId().get(i).getId() + "  The table " + OrderList.getHashMapListOfOrdersPerId().get(i).getTableId() + " ordered " +OrderList.getHashMapListOfOrdersPerId().get(i).getQuantity()+ " " + OrderList.getHashMapListOfOrdersPerId().get(i).getDishName() +"\n");
		}
		
		else
			{
			kitchenLinkedList.add(OrderList.getRandomHashMapListOfOrdersPerId().get(i));
			log.addEntry("order ID : " + OrderList.getRandomHashMapListOfOrdersPerId().get(i).getId() + "  The table " + OrderList.getRandomHashMapListOfOrdersPerId().get(i).getTableId() 
					+ " ordered " +OrderList.getRandomHashMapListOfOrdersPerId().get(i).getQuantity()+ " " + 
					OrderList.getRandomHashMapListOfOrdersPerId().get(i).getDishName() +"\n");
			}

		this.getKitchenListView();
		this.getHatchListView();
		this.getTablesView();

		setChanged();
		notifyObservers();
		clearChanged();
	}

	public synchronized void fromKitchenToHatch() {

		try {
			hatchLinkedList.add(kitchenLinkedList.getFirst());
			log.addEntry("The order " +kitchenLinkedList.getFirst().getId() + " for the table " + kitchenLinkedList.getFirst().getTableId() + " which has " + kitchenLinkedList.getFirst().getQuantity() + "  " + kitchenLinkedList.getFirst().getDishName() + " has sent to hatch" + "\n");
		} catch (Exception e) {

		}
		try {
			kitchenLinkedList.removeFirst();
		} catch (Exception e) {
			kitchenFinished = true;
		}
		this.getKitchenListView();
		this.getHatchListView();
		this.getTablesView();
		setChanged();
		notifyObservers();
		clearChanged();

	}

	public synchronized void fromHatchToTables() {

		try {
			finalLinkedList.add(hatchLinkedList.getFirst());
			log.addEntry("The order " + hatchLinkedList.getFirst().getId() + " is now in the table " + hatchLinkedList.getFirst().getTableId() + " \n");
		} catch (Exception e) {
		}
		try {
			hatchLinkedList.removeFirst();
		} catch (Exception e) {
			hatchFinished = true;
		}
		this.getKitchenListView();
		this.getHatchListView();
		this.getTablesView();
		setChanged();
		notifyObservers();
		clearChanged();
	}

	public static void getSlowerTime() {
		fromOrdersToKitchen.ordTimer = fromOrdersToKitchen.ordTimer / 2;
		fromOrdersToKitchen.x = fromOrdersToKitchen.x * 2;
		fromKitchenToHatch.y = fromKitchenToHatch.y * 2;
		fromHatchToTables.z = fromHatchToTables.z * 2;
	}

	public static void getFasterTime() {
		fromOrdersToKitchen.ordTimer = fromOrdersToKitchen.ordTimer * 2;
		fromOrdersToKitchen.x = fromOrdersToKitchen.x / 2;
		fromKitchenToHatch.y = fromKitchenToHatch.y / 2;
		fromHatchToTables.z = fromHatchToTables.z / 2;
	}

	public static void getNormalTime() {
		fromOrdersToKitchen.ordTimer = 20;
		fromOrdersToKitchen.x = 1000;
		fromKitchenToHatch.y = 2000;
		fromHatchToTables.z = 2800;
	}

	// Get the final HashMapOfOrders
	public static HashMap<Integer, HashSet<Order>> getFinalHashMapOfOrders() {
		return hashMapOfOrders;
	}

	// Get All String Names of Orders
	public static HashSet<String> getAllStringNamesOfOrders() {
		return allStringNamesOrders;
	}
	
	public void setFinished(){
		
		weAreFinishedForToday=true;
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	public boolean getFinished(){
		return weAreFinishedForToday;
	}
	

}
