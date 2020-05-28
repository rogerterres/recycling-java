package com.javamasterclass;

public class Main {

    public static void main(String[] args) {

        //
        // Create a new class for a bank account
        // Create fields for the account number, balance, customer name, email and phone number.
        //
        // Create getters and setters for each field
        // Create two additional methods
        // 1. To allow the customer to deposit funds (this should increment the balance field).
        // 2. To allow the customer to withdrawal to complete if their are insufficient funds.
        // but not allow the withdrawal to complete if their are insufficient funds.
        // You will want to create various code in the Main class (the one created by IntelliJ) to
        // confirm you code is working.
        // Add some System.out.println's in the two methods above as well.
        //

        Account rogerAccount = new Account();
//        Account rogerAccount = new Account("36925814-7", 0.00, "Roger Terres", "roger@terres.com", "(514) 123-4567");
//        rogerAccount.setNumber("14725836-9");
//        rogerAccount.setBalance(0.00);
//        rogerAccount.setCustomerName("Roger Terres");
//        rogerAccount.setCustomerEmailAddress("roger@terres.com");
//        rogerAccount.setCustomerPhoneNUmber("(514) 123-4567");
        System.out.println(rogerAccount.getNumber());
        System.out.println(rogerAccount.getBalance());

        rogerAccount.withdrawal(100.0);
        rogerAccount.deposit(50.0);
        rogerAccount.withdrawal(100.0);
        rogerAccount.deposit(51.0);
        rogerAccount.withdrawal(100.0);

        Account myAccount = new Account("Me", "me@terres.com", "32145698-7");
        System.out.println(myAccount.getNumber() + " name " + myAccount.getCustomerName());

        //
        // Create a new class VipCustomer
        // It should have 3 fields name, credit limit, and email address.
        // Create 3 constructors
        // 1st constructor empty should call the constructor with 3 parameters with default values
        // 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
        // 3rd constructor should save all fields.
        // Create getters only for this using code generation of IntelliJ as setters wont be needed
        // Test and confirm it works.
        //

        VipCustomer customer1 = new VipCustomer();
        System.out.println(customer1.getName());

        VipCustomer customer2 = new VipCustomer("Roger", 25_000.00);
        System.out.println(customer2.getName());

        VipCustomer customer3 = new VipCustomer("Tim", 100.00, "tim@email.com");
        System.out.println(customer3.getName());
        System.out.println(customer3.getEmailAddress());
    }
}
