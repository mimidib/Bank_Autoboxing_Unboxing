package com.dib;

public class Main {

    public static void main(String[] args) {
        //make 1 bank
        Bank bank = new Bank("TD Bank");

        //make 1 branch (a)
        bank.addBranch("Walkley");
        // make 1 customer for (a) branch
        bank.addCustomer("Walkley","CJ", 800000.00);
        bank.addCustomer("Walkley", "Big Smoke", 98000.00);
        bank.addCustomer("Walkley", "Trevor", 7654234.99);

        //add a transaction for an existing customer for a branch (a)
        bank.addCustomerTransaction("Walkley", "CJ",300000.00);
        bank.addCustomerTransaction("Walkley", "Big Smoke", -1000.00);

        //add a new branch (b)
        bank.addBranch("Southkeys");
        bank.addCustomer("Southkeys", "Mike", 100.00);

        //show all customers and transactions
        System.out.println("-------------------------------------------");
        bank.listCustomers("Southkeys",true);
        System.out.println("-------------------------------------------");
        bank.listCustomers("Walkley",true);
    }
}
