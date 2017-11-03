package mvcModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

//This Class returns all the important methods for the Menu Collection
public class MenuList {

	// attribute
	private static ReadMenu rd = new ReadMenu();

	// Return the HashSet of the Menu Items
	public static HashSet<Dish> getHashSetMenuItems() {
		return rd.getFileMenuCollection();
	}

	// Returns all the Names of the Dishes of the Menu in Strings
	public static HashSet<String> getHashSetStringNames() {
		HashSet<String> hs = new HashSet<String>();
		for (Dish dish : rd.getFileMenuCollection())
			hs.add(dish.getName());
		return hs;
	}

	// Get HashMap<DishNames,Prices>
	public static HashMap<String, Double> getHashMapDishesAndPrices() {
		HashMap<String, Double> hs = new HashMap<String, Double>();
		for (Dish dish : rd.getFileMenuCollection())
			hs.put(dish.getName(), dish.getPrice());
		return hs;
	}

	// Get String of the Menu per Category (Catalog)
	public static String getStringCatalog() {

		TreeSet<Dish> starterDishes = new TreeSet<Dish>();
		TreeSet<Dish> mainDishes = new TreeSet<Dish>();
		TreeSet<Dish> dessertDishes = new TreeSet<Dish>();
		TreeSet<Dish> drinkDishes = new TreeSet<Dish>();

		// Convert HashSet to TreeSets

		for (Dish dish : rd.getFileMenuCollection()) {

			if (dish.getCategory().equals("STARTER"))
				starterDishes.add(dish);
			else if (dish.getCategory().equals("MAIN"))
				mainDishes.add(dish);
			else if (dish.getCategory().equals("DESSERT"))
				dessertDishes.add(dish);
			else if (dish.getCategory().equals("DRINKS"))
				drinkDishes.add(dish);
		}

		// Create the Catalog String
		String s = "";
		s += String.format("%40s", "MENU") + "\n";
		s += String.format("%43s", "===========") + "\n" + "\n";
		s += (String.format("%42s", "STARTERS") + "\n" + "\n");
		for (Dish dish : rd.getFileMenuCollection())
			s += String.format("%25s%25s%2s", dish.getName(), dish.getPrice(), "$") + "\n";
		s += ("\n" + String.format("%40s", "MAIN") + "\n" + "\n");
		for (Dish dish : mainDishes)
			s += (String.format("%25s%25s%2s", dish.getName(), dish.getPrice(), "$") + "\n");
		s += ("\n" + String.format("%42s", "DESSERTS") + "\n" + "\n");
		for (Dish dish : dessertDishes)
			s += (String.format("%25s%25s%2s", dish.getName(), dish.getPrice(), "$") + "\n");
		s += ("\n" + String.format("%40s", "DRINKS") + "\n" + "\n");
		for (Dish dish : drinkDishes)
			s += (String.format("%25s%25s%2s", dish.getName(), dish.getPrice(), "$") + "\n");

		return s;

	}
}
