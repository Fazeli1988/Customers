package com.mysite.customer.service;

import com.mysite.customer.model.Customer;
import com.mysite.customer.model.LegalCustomer;
import com.mysite.customer.model.RealCustomer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService implements AutoCloseable{
    private ArrayList<Customer> customers=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    public void run(){
        int choice;

        do{
            PrintMenu();
            choice= scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    AddCustomer();
                    break;
                case 2:
                    PrintAllCustomers();
                    break;
                case 3:
                    searchAndPrintCustomersByName();
                    break;
                case 4:
                    searchAndPrintCustomersByFamily();
                    break;
                case 5:
                    searchAndEditCustomersByName();
                    break;
                case 6:
                    searchAndDeleteCustomersByName();
                    break;
                case 0:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }while (choice!=0);
        scanner.close();
    }

    private void searchAndDeleteCustomersByName() {
        String name = getUserInput("Enter Name:");
        customers.removeIf(customer -> customer.getName().equalsIgnoreCase(name));
    }

    private void searchAndEditCustomersByName() {

        String name = getUserInput("Enter name:");
        for (Customer customer : customers) {
            if(customer.getName().equalsIgnoreCase(name)){
                System.out.println(customer);
                String number = getUserInput("Enter number:");
                customer.setNumber(number);
                if (customer instanceof RealCustomer realCustomer){
                    String family = getUserInput("Enter New family:");
                    realCustomer.setFamily(family);
                } else if (customer instanceof LegalCustomer legalCustomer) {
                    String fax = getUserInput("Enter fax number:");
                    legalCustomer.setFax(fax);
                }
                name="";
                System.out.println(customer);
            }
        }
    }

    private void searchAndPrintCustomersByFamily() {
        String family = getUserInput("Enter family:");
        customers.stream()
                .filter(customer -> customer instanceof RealCustomer)
                .map(customer -> (RealCustomer)customer)
                .filter(realCustomer -> realCustomer.getFamily().equalsIgnoreCase(family))
                .forEach(System.out::println);
    }

    private void searchAndPrintCustomersByName() {
        String name = getUserInput("Enter name:");
        customers.stream()
                .filter(customer -> customer.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    private void PrintMenu() {
        System.out.println("Menu:");
        System.out.println("0.Exit");
        System.out.println("1. Add Customer");
        System.out.println("2. Print All Customer");
        System.out.println("3. Search and print customer by name");
        System.out.println("4. Search and print customer by family");
        System.out.println("5. Search and edit customer by name");
        System.out.println("6. Search and delete customer by name");
        System.out.print("Enter your choice: ");
        System.out.println();
    }
    private    void PrintAllCustomers() {
        if(customers.isEmpty()){
            System.out.println("Customer list is empty");
        }
        else {
            System.out.println("All Customer:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public   void AddCustomer(){
        System.out.println("Customer Type:");
        System.out.println("1. Real");
        System.out.println("2. Legal (2 or other numbers)");
        int choice=scanner.nextInt();
        scanner.nextLine();
        if (choice==1){
            String name = getUserInput("Enter name:");
            String family = getUserInput("Enter family:");
            String number = getUserInput("Enter number as Number :");
            RealCustomer realCustomer=new RealCustomer(name,number);
            realCustomer.setFamily(family);
            customers.add(realCustomer);
        }
        else {
            String name = getUserInput("Enter name:");
            String fax = getUserInput("Enter fax:");
            String number = getUserInput("Enter number as Number :");
            LegalCustomer legalCustomer=new LegalCustomer(name,number);
            legalCustomer.setFax(fax);
            customers.add(legalCustomer);
        }
        System.out.println("Customer added successfully");

    }

    private String getUserInput(String massage) {
        System.out.println(massage);
        return scanner.nextLine();
    }

    @Override
    public void close()  {
        scanner.close();
    }
}

