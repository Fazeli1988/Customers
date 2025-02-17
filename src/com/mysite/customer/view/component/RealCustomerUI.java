package com.mysite.customer.view.component;

import com.mysite.customer.dto.CustomerDto;
import com.mysite.customer.dto.RealCustomerDto;
import java.util.function.Function;

public class RealCustomerUI extends AbstractCustomerUI{

    public RealCustomerUI() {
        super();
    }

    @Override
    public CustomerDto additionalGenerateCustomer(String name, String number) {
        String family = scannerWrapper.getUserInput("Enter family:", Function.identity());
        RealCustomerDto realCustomer=new RealCustomerDto(null,name,number);
        realCustomer.setFamily(family);
        return realCustomer;
    }

    @Override
    public void editCustomer(CustomerDto customer) {
        RealCustomerDto realCustomer=(RealCustomerDto)customer;
        String number = scannerWrapper.getUserInput("Enter number:", Function.identity());
        customer.setNumber(number);
        String family = scannerWrapper.getUserInput("Enter New family:", Function.identity());
        realCustomer.setFamily(family);
    }
}
