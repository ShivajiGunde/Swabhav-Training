package com.functional.model;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
//Annonymous class
//	        Predicate<Integer> isEven = new Predicate<Integer>() {
//	        	
//	            @Override
//	            public boolean test(Integer num) {
//	                return num % 2 == 0;
//	            }
//	        };
//
//	        System.out.println(isEven.test(10)); // true
//	        System.out.println(isEven.test(7));  // false

		
		//Lambda expression
		Predicate<Integer> isEven = n -> n % 2 == 0;
		
		System.out.println(isEven.test(10)); // true
       System.out.println(isEven.test(7));  // false
		
//	    }
	}
}
