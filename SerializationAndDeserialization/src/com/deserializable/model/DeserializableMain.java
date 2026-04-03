//package com.deserializable.model;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//import com.serializable.model.Employee;
//
//public class DeserializableMain {
//	
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		
//		
//		try {
//			FileInputStream fis = new FileInputStream("employee.des");
//			
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			
//			Employee employee2 = (Employee) ois.readObject();
//			
//			
//			ois.close();
//			fis.close();
//			
//			System.out.println("Id: "+employee2.getId());
//			System.out.println("Name: "+employee2.getName());
//			
//			
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
