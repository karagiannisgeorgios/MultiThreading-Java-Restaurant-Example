package mvcModel;

//The Class that represents the Orders
public class Order {

	// attributes
	private static int instanceCounter = 0;
	int id = 1;
	private String dishName;
	private int quantity;
	private int tableId;
	private boolean accepted;

	// Constructor
	public Order(int tableId, String dishName, int quantity) {
		accepted = true;
		this.dishName = dishName;
		this.quantity = quantity;
		this.tableId = tableId;
		instanceCounter++;
		id = instanceCounter;
	}

	// Get Methods
	public int getId() {
		return id;
	}

	public String getDishName() {
		return dishName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTableId() {
		return tableId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Method getString Details
	public String getOrderDetails() {
		return "   " + id + "st order  " + "  for table  " + tableId + ":  -->  " + dishName + "   *   " + quantity
				+ "\n";
	}

	// Method getString Short Details
	
	public String getOrderShortDetails() {
		if(accepted)
		return " -  " + dishName + "   *   " + quantity + "  " + "\n";
		else
			return "The Dish " + dishName + " is not accepted again " + "\n";
	}

	// For HashSet Method
	public boolean equals(Object other) {
		Order otherOrder = (Order) other;

		if (this.getDishName().equals(otherOrder.getDishName()) && this.getTableId() == otherOrder.getTableId()) {
			// The quantity of the Dish remains the same. Will not be counted
			otherOrder.setQuantity(quantity);
			accepted = false;
			return otherOrder.getDishName().equals(this.getDishName());
		} else {
			// Ads the quantity of the Dish
			otherOrder.setQuantity(quantity + otherOrder.getQuantity());
			return otherOrder.getDishName().equals(this.getDishName());
		}
	}

	public int hashCode() {
		return dishName.hashCode();
	}

}
