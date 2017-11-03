package mvcController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvcModel.Restaurant_Model;
import mvcView.Bill_View;
import mvcView.Restaurant_View;

public class Restaurant_Controller {

	private Restaurant_Model model;
	private Restaurant_View view;
	private int sameCounter = 0;

	// Constructor
	public Restaurant_Controller(Restaurant_Model model, Restaurant_View view) {
		this.model = model;
		this.view = view;

		this.view.addStartButtonListener(new StartButtonListener());
		this.view.addSlowerButtonListener(new SlowerButtonListener());
		this.view.addNormalButtonListener(new NormalButtonListener());
		this.view.addFasterButtonListener(new FasterButtonListener());
		this.view.addBillButtonListener(new BillButtonListener());

	}

	// Start Button -- Starts the Model
	class StartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			view.releaseSpeedButtons();
			view.disableStartButton();
			view.setSpeedTimer(2);
			model.start();

		}
	}

	// Slow Button
	class SlowerButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			view.setSpeedTimer(3);
			Restaurant_Model.getSlowerTime();
			sameCounter++;
			if (sameCounter > 0) {
				view.disableSlowButton();
				view.enableFastButton();
				sameCounter = 0;
			}
		}
	}

	// Normal Button
	class NormalButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			view.setSpeedTimer(2);
			Restaurant_Model.getNormalTime();
			view.enableSlowButton();
			view.enableFastButton();
			sameCounter = 0;
		}
	}

	// Fast Button
	class FasterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			view.setSpeedTimer(1);
			Restaurant_Model.getFasterTime();
			sameCounter++;
			if (sameCounter > 0) {
				view.enableSlowButton();
				view.disableFastButton();
				sameCounter = 0;
			}
		}
	}

	// Bill Button -- Starts the Bill
	class BillButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Bill_View bill = new Bill_View();
		}
	}

}
