package com.mysite.customer.util;

import com.mysite.customer.service.exception.ValidationException;

public class NumberValidator {
    public static boolean validate(String number){
        return (number!=null)&&
                number.matches("^0\\d{10}$|^00\\d{12}$|^\\+\\d{12}$");
        }
}
