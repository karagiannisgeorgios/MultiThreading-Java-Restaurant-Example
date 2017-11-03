package mvcModel;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class fromHatchToTables implements Runnable {

	private Restaurant_Model model;

	static int z = 2800;

	public fromHatchToTables(Restaurant_Model model) {
		this.model = model;
	}

	public void run() {

		try {
			while (!model.hatchFinished) {
				Thread.sleep(z);
				model.fromHatchToTables();
			}
			
		} catch (InterruptedException e) {

		}
		
		try 
		{
			Log.getLogOblect().logFinised();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		model.setFinished();
		try {
			FrequencyReport.createFrequencyReport();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
