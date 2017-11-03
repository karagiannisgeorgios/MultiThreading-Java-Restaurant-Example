package mvcModel;

public class fromOrdersToKitchen implements Runnable {

	private Restaurant_Model model;

	static int ordTimer = 20;
	static int x = 1000;

	public fromOrdersToKitchen(Restaurant_Model model) {
		this.model = model;
	}

	public void run() {

		try {
			for (int i = 1; i < ordTimer; i++) {
				Thread.sleep(x);
				model.fromOrdersToKitchen(i);
			}
		} catch (InterruptedException e) {
			System.out.println("STOP1");
		}
	}

}
