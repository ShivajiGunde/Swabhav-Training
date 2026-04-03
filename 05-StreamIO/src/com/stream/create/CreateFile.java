package com.stream.create;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	
	public static void main(String[] args)  {
		
		try {
		File objFile = new File("MyData.txt");
		
		
			if(objFile.createNewFile()) {
			System.out.println("File Created Sucessfully "+objFile.getName());
			
			}else {
				System.out.println("File is Already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
