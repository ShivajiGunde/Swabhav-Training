package com.hospital.model;

public class GeneralConsultation extends Hospital implements ServiceEligibilityChecker{

	public GeneralConsultation(int serviceId, String patientName, double consultationFee) {
		super(serviceId, patientName, consultationFee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serviceType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EligibilityCheck() {
		// TODO Auto-generated method stub
		
	}

}
