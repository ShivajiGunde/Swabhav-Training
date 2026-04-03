package com.stream.writefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	public static void main(String[] args) {
		
		try {
			
			FileWriter fWriter = new FileWriter("myData.txt");
		
		fWriter.write("Java is very powerful");
		fWriter.close();
		
	      System.out.println("Successfully wrote to the file.");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
