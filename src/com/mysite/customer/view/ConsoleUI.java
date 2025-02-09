package com.mysite.customer.view;

import com.mysite.customer.model.Customer;
import com.mysite.customer.model.LegalCustomer;
import com.mysite.customer.model.RealCustomer;
import com.mysite.customer.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI  implements AutoCloseable{
    Scanner scanner=new Scanner(System.in);
    CustomerService customerService=new CustomerService();
    public void startMenu(){
        int choice;

        do{
            PrintMenu();
            choice= scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    printAllCustomers();
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
    private String getUserInput(String massage) {
        System.out.println(massage);
        return scanner.nextLine();
    }
    @Override
    public void close()  {
        scanner.close();
    }

    private void addCustomer(){
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
            customerService.addCustomer(realCustomer);
        }
        else {
            String name = getUserInput("Enter name:");
            String fax = getUserInput("Enter fax:");
            String number = getUserInput("Enter number as Number :");
            LegalCustomer legalCustomer=new LegalCustomer(name,number);
            legalCustomer.setFax(fax);
            customerService.addCustomer(legalCustomer);
        }
        System.out.println("Customer added successfully");
    }

    private void printAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        if(allCustomers.isEmpty()){
            System.out.println("Customer list is empty");
        }
        else {
            System.out.println("All Customer:");
            for (Customer customer : allCustomers) {
                System.out.println(customer);
            }
        }
    }
    private void searchAndPrintCustomersByName() {
        String name = getUserInput("Enter name:");
        List<Customer> customers = customerService.searchCustomersByName(name);
        customers.forEach(System.out::println);
    }
    private void searchAndPrintCustomersByFamily() {
        String family = getUserInput("Enter family:");
        List<Customer>customers=customerService.searchCustomersByFamily(family);
        customers.forEach(System.out::println);
    }
    private void searchAndEditCustomersByName() {
        String name = getUserInput("Enter name:");
        List<Customer>customers=customerService.searchCustomersByName(name);
        for (Customer customer : customers) {
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
    private void searchAndDeleteCustomersByName() {
        String name = getUserInput("Enter Name:");
       customerService.searchAndDeleteCustomersByName(name);
    }
    }

