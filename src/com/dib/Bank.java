package com.dib;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches; //has a list of branches

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<>();
    }

    //add a new branch - validate branch name is unique
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) { //if branchName is unique
            this.branches.add(new Branch(branchName)); //Good: new Branch(branchName) calls branch constructor
            System.out.println("Bank.addBranch()-> Successfully added branch '" + branchName + "'.");
            return true;
        }
        System.out.println("Bank.addBranch()-> Duplicate branch name '" + branchName + "'. Cannot add new branch");
        return false;
    }

    //add a customer to a branch with initial transaction amount
    public boolean addCustomer(String branchName, String customerName, double initAmount) {
        //check if branchName exists
        Branch theBranch = findBranch(branchName);
        if (theBranch != null) {
            //if branchName exists -> customer name validation is done in Branch class
            //add customer with transaction to further validate
            return theBranch.addNewCustomer(customerName, initAmount); //returns status of branch method boolean result
        }
        System.out.println("Bank.addCustomerToBranch()-> Branch name '" + branchName + "' does not exist.");
        return false;
    }

    //add a transaction for an existing customer for that branch
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        //check if branchName exists
        Branch theBranch = findBranch(branchName);
        if (theBranch != null) {
            // That specific branches' customer list is queried for customer in theBranch.addCustomerTransaction().
            //add transaction for found customer record in branch
            return theBranch.addCustomerTransaction(customerName, amount); //return result of this method's return boolean

        }
        System.out.println("Bank.addCustomerTransaction() -> Cannot find branch name: " + branchName);
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            //get index of current branch
            Branch theBranch = branches.get(i);
            if (theBranch.getBranchName().equals(branchName)) {
                return theBranch;
            }
        }
        return null;
    }

    //show a list of customers for a particular branch
    public boolean listCustomers(String branchName, boolean showTransactions) { //boolean to list a customers transactions or not
        //check if branch exists
        Branch theBranch = findBranch(branchName);
        if (theBranch != null) {
            System.out.println("Customers for branch " + theBranch.getBranchName());//Good: use branch obj here not branchName param for ez readability
            //list of branch customer records
            ArrayList<Customer> branchCustomers = theBranch.getCustomers(); //if its empty no exception is thrown since we are initializing the Arraylist and using .size(), printing one of size 0 is handled by printing nothing
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    //since there's multiple transactions per customer, it's best to save in an arraylist to iterate
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    System.out.println("Transactions: ");
                    //loop through all transactions and print
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));//after get(j).doubleValue() isn't needed cus we're using unboxing
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
