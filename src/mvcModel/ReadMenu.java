package mvcModel;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

//The Class that Reads the Menu *txt file and stores in Hashset Collection 
public class ReadMenu {
	// Main Data Structure for Menu
	private HashSet<Dish> dishes = new HashSet<Dish>();
	// error line counter attributes
	private int errorLineOther = 1;
	private int errorLinePrice = 1;
	private int errorLineCategory = 0;

	public ReadMenu() {

		// File menuFile = new File("/PackageFiles/menu.txt");

		Scanner scannerMenu = null;

		// reads every single line from our file
		try {
			scannerMenu = new Scanner(getClass().getResourceAsStream("/PackageFiles/menu.txt"));
		} catch (Exception e) {
			System.out.println("Sorry, the Menu file is missing");
			System.exit(0);
		}

		while (scannerMenu.hasNextLine()) {

			String inputLine = scannerMenu.nextLine();
			String Dishparts[] = inputLine.split(",");

			// my variables before try and catch

			String dishName = "";
			String dsPrice = "";
			double dishPrice = 0;
			String dishCategory = "";

			// try out of bounds error which catches it in the end
			try {
				// variable which will count on which line our error is

				errorLineOther++;
				// Removes any space in front of our dish Name

				dishName = Dishparts[0];

				if (Character.isWhitespace(dishName.charAt(0))) {
					dishName = dishName.replaceFirst("\\s+", "");
				}

				/*
				 * Converting our String inputs into our preferred variables
				 * catch and try for wrong cabin number input
				 */

				dsPrice = Dishparts[1];
				dsPrice = dsPrice.trim();

				try {
					dishPrice = Double.parseDouble(dsPrice);
					dishPrice = Math.round(dishPrice * 1e2) / 1e2;

					// counter for error line
					errorLinePrice++;
				} catch (Exception e) {
					System.out.println("Wrong Input in Line " + errorLinePrice + " in the Menu File !" + "\n"
							+ "As a Price of the Dish the program only accepts double variables");
					System.exit(0);
				}

				dishCategory = Dishparts[2];
				dishCategory = dishCategory.trim();
				dishCategory = dishCategory.toUpperCase();
				errorLineCategory++;
				if (!(dishCategory.equals("STARTER") || dishCategory.equals("MAIN") || dishCategory.equals("DESSERT")
						|| dishCategory.equals("DRINKS"))) {
					System.out.println("Wrong Input in Line " + errorLineCategory + " in the Menu File  !" + "\n"
							+ "As a Category of the Dish the program only accepts Starter,Main,Dessert or Drinks as variables");
					System.exit(0);
				}

			} catch (Exception e) {
				int errorLineOtherMinusOne = errorLineOther - 1;
				System.out.println("Problem in Line " + errorLineOtherMinusOne + " in the Menu File  !" + "\n"
						+ "Check your input again." + "\n" + "Check if you haven’t forgotten any commas. ");
				System.exit(0);
			}
			Dish eachDish = new Dish(dishName, dishPrice, dishCategory);

			dishes.add(eachDish);

		}
		scannerMenu.close();
	}

	// Method which returns the the Menu Collections that was read from the file
	public HashSet<Dish> getFileMenuCollection() {
		return dishes;
	}

}
