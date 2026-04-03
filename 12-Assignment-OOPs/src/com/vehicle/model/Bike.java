package com.vehicle.model;

public class Bike extends Vehicle{

    private boolean hasCarrier;

	public Bike(String ownerName, double baseUsageCharge,boolean hasCarrier) {
		super(ownerName, baseUsageCharge);

		this.hasCarrier = hasCarrier;
	}
	
	public boolean isHasCarrier() {
        return hasCarrier;
    }

    public void setHasCarrier(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

	@Override
	public void display() {
		System.out.println("RegistrationNumber: "+registrationNumber);
		System.out.println("OwnerName: "+ownerName);
		System.out.println("BaseCharges: "+baseUsageCharge);
		System.out.println("HasCarrier: "+hasCarrier);		
	}

}
