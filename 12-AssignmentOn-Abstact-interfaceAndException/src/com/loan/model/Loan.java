package com.loan.model;

public abstract class Loan {
	
	 private String loanId;
	    private String borrowerName;
	    private double principalAmount;
	    private double interestRate;
	    
	    static {
	        System.out.println("Loading Digital Loan Processing System");
	    }
	    
	    public Loan(String borrowerName, double principalAmount, double interestRate)
	            throws InvalidLoanException {

	        if (principalAmount <= 0) {
	            throw new InvalidLoanException("Principal amount must be positive.");
	        }

	        if (interestRate <= 0) {
	            throw new InvalidLoanException("Interest rate must be positive.");
	        }
	        if(borrowerName.isEmpty() || !borrowerName.matches("[a-zA-Z]+")) {
	        	throw new IllegalArgumentException("Name cannot be empty");
	        }

	        
	        
	        this.loanId = generateLoanId();
	        this.borrowerName = borrowerName;
	        this.principalAmount = principalAmount;
	        this.interestRate = interestRate;
	        

	    }
	    private String generateLoanId() {

	    	return "LID:"+System.currentTimeMillis();
		}
		public String getLoanId() {
	        return loanId;
	    }

	    public String getBorrowerName() {
	        return borrowerName;
	    }

	    public double getPrincipalAmount() {
	        return principalAmount;
	    }

	    public double getInterestRate() {
	        return interestRate;
	    }
	    
	    


	    public abstract double calculateRepayment();
	    
	    public void display() {
	    	
	    	 System.out.println("Loan ID: " + loanId);
	         System.out.println("Borrower: " + borrowerName);
	         System.out.println("Principal Amount: " + principalAmount);
	         System.out.println("Interest Rate: " + interestRate);	
     
	    }
		

}
