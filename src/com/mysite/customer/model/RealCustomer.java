package com.mysite.customer.model;

public class RealCustomer extends Customer{
    private String family;

    @Override
    public String toString() {
        return "PersonalContact{" +
                super.toString()+
                ", family='" + family + '\'' +
                '}';
    }

    public RealCustomer(String name, String number) {
        super(name, number, CustomerType.REAL);
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
