package com.company;

public class Customer {
    private int id;
    private String name;
    private String address;
    private Boolean isSpecial;

    public void display(){
        System.out.println("Customer ID is " + id + "\nCustomer Name is " + name + "\nCustomer Address is " + address + "\nCustomer is special: " + isSpecial);
        System.out.println();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setIsSpecial(Boolean isSpecial){
        this.isSpecial = isSpecial;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public Boolean getIsSpecial(){
        return isSpecial;
    }
}
