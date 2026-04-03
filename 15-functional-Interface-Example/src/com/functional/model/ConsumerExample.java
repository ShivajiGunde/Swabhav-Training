package com.functional.model;
import java.util.function.Consumer;

public class ConsumerExample {
	

	    public static void main(String[] args) {

	    	
	    	Consumer<String> printName = (name) -> System.out.println(name);
	    	
	    	printName.accept("Mahesh");
	    	
//	        Consumer<String> printName = new Consumer<String>() {
//	            @Override
//	            public void accept(String name) {
//	                System.out.println("Name: " + name);
//	            }
//	        };
//
//	        printName.accept("Ravi");
	    }
//	    }
	}


