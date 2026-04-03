package com.objectcasting.model;

public class Animal {

	void sound() {
		System.out.println("Animal makes sound");
	}

}

class Dog extends Animal {

	void bark() {

		System.out.println("Dog barks");
	}

}

class UpCasting {
	public static void main(String[] args) {

		Animal a = new Dog(); // upcasting 

		a.sound();
	}
}

class DownCasting {

	public static void main(String[] args) {

		Animal a = new Dog();

		Dog d = (Dog) a; // downcasting  (parent -> child)
		
		d.bark();
	}
}
