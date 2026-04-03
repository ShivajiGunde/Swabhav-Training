package com.serializable.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {

		// Serialization
		try {
			Employee employee = new Employee(101, "Rahul");

			FileOutputStream fos = new FileOutputStream("employee.ser");

			ObjectOutputStream os = new ObjectOutputStream(fos);

			os.writeObject(employee);
			os.close();

			fos.close();

			System.out.println("Serialized sucessfully");

		} catch (IOException e) {
			e.printStackTrace();

		}

		// Deserialization

		try {
			FileInputStream fis = new FileInputStream("employee.ser");

			ObjectInputStream ois = new ObjectInputStream(fis);

			Employee employee2 = (Employee) ois.readObject();

			ois.close();
			fis.close();
			
			System.out.println("Id: "+employee2.getId());
			System.out.println("NAme: "+employee2.getName());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
