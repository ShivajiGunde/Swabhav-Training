package com.hospital.model;

import com.order.model.Order;

public class Patient implements Comparable<Patient>{

	private int patientId;
	private String name;
	private int age;

	public Patient(int patientId, String name, int age) {
		super();
		
		if (patientId <= 0) {

			throw new IllegalArgumentException("Patient id cannot be negative");
		}
		this.patientId = patientId;
		
		if (name.isEmpty() || !name.matches("[a-zA-Z]+")) {

			throw new IllegalArgumentException("Name cannot be null");
		}
		this.name = name;
		
		if (patientId <= 0) {

			throw new IllegalArgumentException("Patient id cannot be negative");
		}
		this.age = age;
	}

	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Patient))
			return false;
		return this.patientId == ((Patient) obj).patientId;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(patientId);
	}
	@Override
	public int compareTo(Patient p) {

		return Integer.compare(p.getPatientId(), this.getPatientId());

	}

}
