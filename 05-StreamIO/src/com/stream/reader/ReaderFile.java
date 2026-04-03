package com.stream.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReaderFile {
	
	public static void main(String[] args) {
		
		try {
			
			File obj = new File("MyData.txt");
			
			Scanner reader = new Scanner(obj);
			
			while(reader.hasNext()) {
				
				String data = reader.nextLine();
				
				System.out.println(data);
			}
			reader.close();
			
			;
		} catch (FileNotFoundException e) {

		e.printStackTrace();
		}
		
		
	}

}
