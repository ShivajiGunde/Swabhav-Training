package com.hospital.model;

public class Nurse extends Staff{
	
	private String shift;

	public Nurse(String name, String department,String shift) {
		super(name, department);
		
		this.shift = shift;
	}


	@Override
	public void display() {

		System.out.println("Nurse Id: "+id);
		System.out.println("Name: "+name);
		System.out.println("Department: "+department);
		System.out.println("Shift: "+shift);
	}

}
