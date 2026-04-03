//package com.stream.examples;
//
//import java.util.List;
//
//public class StreamExample {
//	
//	public static void main(String[] args) {
//		
//		List<String> names = List.of("Amit","rahul","Ganesh");
//		
//		List<String> result = names.stream().filter(name-> name.length() > 3)
//											.map(String::toUpperCase)
//											.toList();
//		
//		System.out.println(result);//[AMIT,RAHUL]
//	}
//
//}
