package com.hospital.model;

public abstract class Hospital {

	private String serviceId;
	private String patientName;
	private double consultationFee;

	public Hospital(int serviceId, String patientName, double consultationFee) {
		super();
		this.serviceId = generateServiceId();
		this.patientName = patientName;
		this.consultationFee = consultationFee;
	}

	public String generateServiceId() {

		return "SID" + System.currentTimeMillis();

	}
	public String getServiceId() {
		return serviceId;
	}

	public String getPatientName() {
		return patientName;
	}

	public double getConsultationFee() {

		return consultationFee;
	}
	
	public abstract void serviceType();

}
