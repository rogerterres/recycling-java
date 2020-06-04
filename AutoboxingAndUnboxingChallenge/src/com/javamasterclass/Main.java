package com.javamasterclass;

public class Main {

    public static void main(String[] args) {
        //
        // You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an ArrayList of Branches
        // Each Branch should have an arraylist of Customers
        // The Customer class should have an ArrayList of Doubles (transactions)
        // Customer: Name, and the ArrayList of doubles.
        // Branch: Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank: Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list of their transactions
        // Demonstration autoboxing and unboxing in your code
        // HINT: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions
        //

        Bank bank = new Bank("Desjardins");
        if (bank.addBranch("Scranton")) {
            System.out.println("Scranton branch created");
        }
        bank.addCustomer("Scranton", "Michael", 1_250.50);
        bank.addCustomer("Scranton", "Dwight", 1_000.00);
        bank.addCustomer("Scranton", "Andy", 856.75);

        bank.addBranch("Utica");
        bank.addCustomer("Utica", "Karen", 1_250.50);
        bank.addCustomer("Utica", "Rolando", 600.00);

        bank.addCustomerTransaction("Scranton", "Michael", 45.22);
        bank.addCustomerTransaction("Scranton", "Dwight", 10.52);
        bank.addCustomerTransaction("Scranton", "Andy", 25.00);

        bank.listCustomers("Scranton", true);
        bank.listCustomers("Utica", true);

//        bank.addBranch("Nashua");
//        bank.addCustomer("Nashua", "Holly", 950.00);
        if (!bank.addCustomer("Nashua", "Holly", 950.00)) {
            System.out.println("Error : Nashua branch does not exists");
        }

        if (!bank.addBranch("Scranton")) {
            System.out.println("Scranton branch already exists");
        }

        if (!bank.addCustomerTransaction("Scranton", "Phillys", 1_050.00)) {
            System.out.println("Customer does not exists at branch");
        }

        if (!bank.addCustomer("Scranton", "Michael", 23.35)) {
            System.out.println("Customer Michael already exists");
        }
    }
}
