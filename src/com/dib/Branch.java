package com.dib;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<>();
    }

    public String getBranchName(){
        return this.branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //Add a new customer and init trans amount
    public boolean addNewCustomer(String customerName, double initAmount){
        //validate unique customer name
        if(findCustomer(customerName) == null){
            //TODO line below practice
            this.customers.add(new Customer(customerName,initAmount));//Good: New Customer(customerName, initAmount) calls constructor code in Customer class
            System.out.println("Branch.newCustomer()-> Successfully added new customer " + customerName + " to branch " + getBranchName());
            return true;
        }
        System.out.println("Branch.newCustomer()-> Adding new customer " + customerName + "failed due to duplicate name.");
        return false;
    }
    //add additional transactions for a customer in a branch
    public boolean addCustomerTransaction(String customerName, double amount) {
        //validate customer name is on file
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            System.out.println("Branch.addCustomerTransaction()-> Successfully added customer Transaction");
            return true;
        }
        System.out.println("Branch.addCustomerTransaction()->No record of " + customerName + " found");
        return false;
    }
    private Customer findCustomer(String customerName){
        //give name, query list of customers for name and retrieve the index and the customer obj
        for(int i=0; i<customers.size();i++){
            //if given name matches a customers name at i index(cant retrieve obj twice in if condition and block
            Customer checkedCustomer = customers.get(i); //checkedCustomer is a ref to the obj, not a new init of obj
            if(checkedCustomer.getName().equals(customerName)){//same as customerName.equals(customers.get(i).getName());
                return checkedCustomer;
            }
        }
        return null;
    }

}
