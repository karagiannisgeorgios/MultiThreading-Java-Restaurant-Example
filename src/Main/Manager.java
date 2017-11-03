package Main;

import mvcController.Restaurant_Controller;
import mvcModel.Restaurant_Model;
import mvcView.Restaurant_View;

public class Manager {
	// Starts the MVC Model
	public static void run() {
		Restaurant_Model theModel = new Restaurant_Model();
		Restaurant_View theView = new Restaurant_View(theModel);
		Restaurant_Controller theController = new Restaurant_Controller(theModel, theView);
		theView.setVisible(true);
	}
}
