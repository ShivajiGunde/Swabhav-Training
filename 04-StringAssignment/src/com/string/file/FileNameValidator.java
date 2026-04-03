package com.string.file;

import java.awt.im.InputContext;
import java.util.Scanner;

public class FileNameValidator {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the file name");
		String file = scanner.nextLine();
		
		//file type check
		boolean isPdf = file.endsWith(".pdf");
		
		System.out.println("FileType: "+(isPdf?"Yes":"No"));

		//find last position of (.)
		int index = file.lastIndexOf(".");
		
		//without extention file name
		String name = file.substring(0,index);
		
		System.out.println("File name: "+name);
		
		//print extension
		String extention = file.substring(index + 1);
		
		System.out.println("Extention: "+extention);
		
		name = name.replace("_"," ");
		
		
		//convert uppercase
		String upperName = name.toUpperCase();
		
		System.out.println("UpperCase: "+upperName);
		
		//checks final 
		boolean contain = name.contains("final");
		
		
		
	}

}
