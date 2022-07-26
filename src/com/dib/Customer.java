package com.dib;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    //autoboxing double to type Double wrapper
    public void addTransaction(double amount){
        System.out.println("Customer.addTransaction()-> Requested transaction amount: " + amount);
        this.transactions.add(amount);


    }

    public String getName() {
        return name;
    }
    public ArrayList<Double> getTransactions(){
        return transactions;
    }
}
