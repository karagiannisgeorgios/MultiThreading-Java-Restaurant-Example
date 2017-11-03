package mvcModel;

public class invalidQuantity extends Exception{

	public invalidQuantity(int errorLineQuantity){
		
	super("Wrong Input in Line " + (errorLineQuantity-1) + " in the Orders File !" + "\n"
			+ "Please you have to order at least 1 dish... You have given a negative number ");	
	}
	
}
