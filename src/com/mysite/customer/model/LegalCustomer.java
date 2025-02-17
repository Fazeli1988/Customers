package com.mysite.customer.model;

public class LegalCustomer extends Customer {
    private String fax;

    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    @Override
    public String toString() {
        return "BusinessContact{" +
                super.toString()+
                ", fax='" + fax + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj){
        return obj instanceof LegalCustomer &&
                ((LegalCustomer) obj).getName().equals(getName()) ;

    }

    public LegalCustomer(String name, String number){
        super(name,number,CustomerType.LEGAL);
    }
}
