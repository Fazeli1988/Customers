package com.mysite.customer.model;

import com.mysite.customer.model.CustomerType;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Customer {
    private static final AtomicInteger ID_COUNTER=new AtomicInteger(1);
    private Integer id;
    private String name;
    private String number;
    private final CustomerType type;
    private Boolean deleted;
    public Customer(String name, String number, CustomerType type) {
        this.id=ID_COUNTER.getAndIncrement();
        this.name = name;
        this.number = number;
        this.type = type;
        this.deleted=false;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public CustomerType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", type=" + type ;
    }

    private String capitalizeFirstCharacter(String str){
        if(str != null && !str.isEmpty()){
            return Character.toUpperCase(str.charAt(0))+str.substring(1);
        }
        return str;
    }
    public String getName(){
        return name;
    }
    public  String getNumber(){
        return number;
    }
    public void setName(String name){
        this.name=capitalizeFirstCharacter(name);
    }
    public void setNumber(String number){
        this.number=number;
    }

}
