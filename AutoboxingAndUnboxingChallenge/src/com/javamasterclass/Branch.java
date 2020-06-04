package com.javamasterclass;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customer;

    public Branch(String name) {
        this.name = name;
        this.customer = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customer.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customer.size(); i++) {
            Customer checkedCustomer = this.customer.get(i);
            if (this.customer.get(i).getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
