package com.monocept.runtimeException;

public class RunTimeException {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30};

        try {
            System.out.println("accessing  4th element: " + arr[3]);

        } catch (ArrayIndexOutOfBoundsException e) {
            
        	System.out.println("Array index is out of bounds");
        }
        
        finally {
			System.out.println("Finally block executed..");
		}

    }
}