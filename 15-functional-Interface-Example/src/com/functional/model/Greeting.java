package com.functional.model;

public interface Greeting {
	
	void sayHello();

}

class Test{

	public static void main(String[] args) {
		
		//Annonimous class
//		Greeting greeting = new Greeting() {
//			
//			@Override
//			public void sayHello() {
//				 System.out.println("Hello");
//			};
//		};
//	}
//}

		
		// Lambda Expression
		Greeting g = () -> System.out.println("Hello");
	
		g.sayHello();
	}
		
	}
	
	

