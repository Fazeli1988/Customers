package com.mysite.customer.service;

import com.mysite.customer.model.Customer;
import com.mysite.customer.service.exception.CustomerNotFindException;
import com.mysite.customer.service.exception.DuplicateCustomerException;
import com.mysite.customer.service.exception.EmptyCustomerException;
import com.mysite.customer.service.exception.ValidationException;

import java.util.List;

public interface CustomerService {
    void deleteCustomersById(Integer id) throws CustomerNotFindException;
    List<Customer> searchCustomersByFamily(String family);
    List<Customer> searchCustomersByName(String name);
    Customer getCustomerById(Integer id) throws CustomerNotFindException;
    List<Customer> getActiveCustomers() throws EmptyCustomerException;
    List<Customer> getDeletedCustomers() throws EmptyCustomerException;
    void addCustomer(Customer customer) throws DuplicateCustomerException, ValidationException;

}
