package com.string.duplicatewords;

public class DupplicateWords {

	public static void main(String[] args) {

		String str = "Java Java is is very very powerful";

//		String[] words = str.split(" ");
//
//		String result = words[0];
//
//		for (int i = 1; i < words.length; i++) {
//			
//			if (!words[i].equals(words[i - 1])) {
//				result += " " + words[i];
//			}
//		}
//		System.out.println(result);

		String[] words = str.split(" ");
		String result = words[0];
		
		for(int i=1;i < words.length;i++) {
			if(!words[i].equals(words[i-1])) {
				
				result += " " + words[i];
			}
		}
		System.out.println(result);
	}

}
