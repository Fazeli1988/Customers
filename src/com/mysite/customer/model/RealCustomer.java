package com.mysite.customer.model;

public class RealCustomer extends Customer{
    private String family;
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
    @Override
    public String toString() {
        return "PersonalContact{" +
                super.toString()+
                ", family='" + family + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof RealCustomer &&
                ((RealCustomer) obj).getName().equals(getName()) &&
                ((RealCustomer) obj).getFamily().equals(getFamily());
    }

    public RealCustomer(String name, String number) {
        super(name, number, CustomerType.REAL);
    }


}
