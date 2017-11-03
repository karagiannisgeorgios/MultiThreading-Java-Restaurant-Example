package mvcModel;

import java.util.Random;

public class fromKitchenToHatch implements Runnable {

	private Restaurant_Model model;

	static int y = 2000;

	public fromKitchenToHatch(Restaurant_Model model) {
		this.model = model;
	}

	public void run() {
		while (!model.kitchenFinished) {
			try {

				Thread.sleep(y);
				model.fromKitchenToHatch();

			} catch (InterruptedException e) {
				System.out.println("STOP2");
			}

		}

	}
}
