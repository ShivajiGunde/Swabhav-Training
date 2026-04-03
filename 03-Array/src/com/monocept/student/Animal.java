package com.monocept.student;

public class Animal {
	
}
class Dog extends Animal{
	
	public void bark() {
		
		System.out.println("Dog bark");
	
	}
	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		Dog dog = (Dog)animal;
		
		dog.bark();
	
	}
}
