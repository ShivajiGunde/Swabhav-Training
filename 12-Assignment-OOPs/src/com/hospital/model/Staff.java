package com.hospital.model;

public abstract class Staff {
	protected long id;
	protected String name;
	protected String department;

	public Staff(String name, String department) {
		super();
		this.id = generateId();
		this.name = name;
		this.department = department;
	}

	private long generateId() {
		
		return System.currentTimeMillis();
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public abstract void display();
}
