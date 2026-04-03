package com.loan.test;

import java.util.Scanner;

import com.loan.model.CarLoan;
import com.loan.model.EducationLoan;
import com.loan.model.HomeLoan;
import com.loan.model.InvalidLoanException;
import com.loan.model.Loan;
import com.loan.model.LoanEligibility;

public class LoanProcessingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of loans: ");
        int n = scanner.nextInt();
        
        if(n <= 0) {
        	
        	throw new IllegalArgumentException("number of loans must be positive");
        }
        scanner.nextLine();

        Loan[] loans = new Loan[n];

        for (int i = 0; i < n; i++) {

            try {

                System.out.println("\nSelect Loan Type");
                System.out.println("1. Home Loan");
                System.out.println("2. Car Loan");
                System.out.println("3. Education Loan");

                int type = scanner.nextInt();
                scanner.nextLine();
                
                if(type < 1 || type > 3) {
                	
                	throw new InvalidLoanException("Invalid Loan type");
                }


                System.out.print("Enter Borrower Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Principal Amount: ");
                double amount = scanner.nextDouble();              

                System.out.print("Enter Interest Rate: ");
                double interestRate = scanner.nextDouble();

                switch (type) {

                    case 1:
                        loans[i] = new HomeLoan(name, amount, interestRate);
                        
                        break;

                    case 2:
                        loans[i] = new CarLoan(name, amount, interestRate);
                        break;

                    case 3:
                        loans[i] = new EducationLoan(name, amount, interestRate);
                        break;

                    default:
                        System.out.println("Invalid loan type");
                        i--;
                }
                
                for(Loan loan : loans) {
                	
                LoanEligibility eligibility = (LoanEligibility) loan;

                boolean result = eligibility.checkLoanEligibility(amount);

                if (result) {

                    System.out.println("Loan Approved");
                    loans[i] = loan;

                } else {

                    System.out.println("Loan Rejected (Eligibility Failed)");
                    i--; 
                }
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n===== Loan Processing =====");

        for (Loan loan : loans) {

            if (loan != null) {

                loan.display();

                double repayment = loan.calculateRepayment();

                System.out.println("Total Repayment Amount: " + repayment);
            }
        }

        scanner.close();
    }
}