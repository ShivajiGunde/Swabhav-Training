package com.functional.model;
import java.util.function.Function;

public class FunctionExamplr {
	

	    public static void main(String[] args) {

	    	
	    	Function<String, Integer> getLength = str -> str.length();
	    	
	    	System.out.println(getLength.apply("Java")); //4
	    	
//	        Function<String, Integer> getLength = new Function<String, Integer>() {
//	            @Override
//	            public Integer apply(String str) {
//	                return str.length();
//	            }
//	        };
//
//	        System.out.println(getLength.apply("Java")); // 4
//	    }
	}
}


