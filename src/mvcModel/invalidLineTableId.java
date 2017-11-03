package mvcModel;

public class invalidLineTableId extends Exception {
	public invalidLineTableId(int errorLineTableId) {
		super( "Wrong Input in Line " + errorLineTableId + " in the Orders File !" + "\n"
							+ "Please Check that you have given a value Table Number ");
	}

}
