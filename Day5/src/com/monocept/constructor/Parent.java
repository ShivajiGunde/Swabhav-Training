package com.monocept.constructor;

public class Parent {
	
	public Parent() {
	}
	public void printMassage() {
	 
	 System.out.println("Parent Constructor");
	
	}
	
	  class Child extends Parent{
	
		
		public void printMassage(String massage) {
			//this.printMassage();
			System.out.println("Child Constructor");		
			}
		
			
			
		}

//		Child(){
//			this.printMassage();
//			super.printMassage();;
//		}
//		
			
		}
}
	


