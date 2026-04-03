package com.hospital.model;

public class Doctor extends Staff{
	private String specialization;

	
	public Doctor(String name, String department,String Specialization) {
		super(name, department);
		this.specialization = specialization;
	}


	@Override
	public void display() {

		System.out.println("DoctorId: "+id);
		System.out.println("Name: "+name);
		System.out.println("Department: "+department);
		System.out.println("Shift: "+specialization);
	}
	

}
