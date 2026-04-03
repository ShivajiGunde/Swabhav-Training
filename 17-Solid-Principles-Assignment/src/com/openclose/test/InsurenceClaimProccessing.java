package com.openclose.test;

import com.openclose.model.Claim;
import com.openclose.model.ClaimProcessor;
import com.openclose.model.LifeClaim;
import com.openclose.model.TravelClaim;
import com.openclose.model.VehicleClaim;

public class InsurenceClaimProccessing {
	
	    public static void main(String[] args) {

	        ClaimProcessor processor = new ClaimProcessor();

	        Claim life = new LifeClaim();
	        Claim vehicle = new VehicleClaim();

	        // New claim type added later
	        Claim travel = new TravelClaim();

	        processor.processClaim(life);
	        processor.processClaim(vehicle);
	        processor.processClaim(travel);
	    }
	}


