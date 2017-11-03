package mvcModel;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Log {
	
	private static final Log LogOblect = new Log();
	private String logFileText;
	
	private Log(){
		logFileText = "The Restaurant Actions for Today \n";
	}
	
	public static Log getLogOblect(){
		return LogOblect;
	}
	
	public void addEntry(String newTextForLogFile){
		logFileText += newTextForLogFile;
	}
	
	public void logFinised() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("logFile.txt");
		writer.print(logFileText);
		writer.close();
	}
}
