package com.monocept.multiplecatch;

public class ArrayException {

	public static void main(String[] args) {

		String[] names = { "Ganesh,Ramesh" };
		
		String str = null;
			

		try {
			System.out.println("Access 5th element: "+names[4]);
			
			System.out.println("Length of String: "+str.length());

		
		}catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Array index out of bounds");
		
		}catch(NullPointerException e) {
			
			System.out.println("cannot get length of null string");
		}

		}
	}


