package com.mysite.customer.service;

import com.mysite.customer.model.Customer;
import com.mysite.customer.model.LegalCustomer;
import com.mysite.customer.model.RealCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerService {
    private ArrayList<Customer> customers=new ArrayList<>();


    public void searchAndDeleteCustomersByName(String name) {
        customers.removeIf(customer -> customer.getName().equalsIgnoreCase(name));
    }


    public List<Customer> searchCustomersByFamily(String family) {
        return customers.stream()
                .filter(customer -> customer instanceof RealCustomer)
                .map(customer -> (RealCustomer)customer)
                .filter(realCustomer -> realCustomer.getFamily().equalsIgnoreCase(family))
                .collect(Collectors.toList());
    }

    public List<Customer> searchCustomersByName(String name) {
        return customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);

    }




}

