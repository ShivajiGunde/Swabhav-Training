package com.serializable.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	 private int id;
	 private String name;
	 
	public Employee(int id, String name) {
		super();
		this.setId(id);
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
  public String getName() {
	  return name;
  }
 

}
