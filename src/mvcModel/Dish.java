package mvcModel;

//The Class that represents the Menu items
public class Dish implements Comparable {

	// attributes
	private String name;
	private double price;
	private String category;

	// Constructor
	public Dish(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	// Get Methods
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	// For HashSet Method
	public boolean equals(Object other) {
		Dish otherDish = (Dish) other;
		return otherDish.getName().equals(this.getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

	// Comparable method
	@Override
	public int compareTo(Object other) {
		Dish otherDish = (Dish) other;
		return name.compareTo(otherDish.getName());

	}

}
