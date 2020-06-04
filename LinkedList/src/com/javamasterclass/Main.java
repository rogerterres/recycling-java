package com.javamasterclass;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tom", 96.54);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(18.12);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + " : " + intList.get(i));
        }

        intList.add(1, 5);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + " : " + intList.get(i));
        }
    }
}
