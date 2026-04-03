package com.openclose.model;

public class OldClaimProcessor {


	    public void processClaim(String type) {

	        if (type.equalsIgnoreCase("life")) {
	            System.out.println("Processing Life Insurance Claim...");
	        } 
	        else if (type.equalsIgnoreCase("vehicle")) {
	            System.out.println("Processing Vehicle Insurance Claim...");
	        } 
	        else if (type.equalsIgnoreCase("health")) {
	            System.out.println("Processing Health Insurance Claim...");
	        }
	    }
	}

