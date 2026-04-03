package com.string.setenceformater;

import java.util.Scanner;

public class SetenceFormatter {

   public static void main(String[] args) {
	
	   Scanner scanner = new Scanner(System.in);
	   
//	   System.out.println("Enter the sentence");
//	   String str = scanner.nextLine().trim();
	   
	   String str1 = "java programming is fun and powerfull";
	   
	//  String toLower = str1.toLowerCase();
	   
	   String starting = str1.substring(0,1).toUpperCase() + str1.substring(1);
	   
	   
	   System.out.println("Sentence start with Capital: "+starting);
	   
	   String replace = str1.replaceAll("fun", "interesting");
	   
	   System.out.println("Replaced sentence : "+replace);
	   
	   String[] words = str1.split(" ");
	   
	   int count = words.length;
	   
	   System.out.println("Count words in sentence: "+count);
	   
	   System.out.println("First Word: "+words[0]);
	   System.out.println("Last World: "+words[count-1]);
	   
}
}
