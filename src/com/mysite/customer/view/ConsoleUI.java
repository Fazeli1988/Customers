package com.mysite.customer.view;

import com.mysite.customer.model.Customer;
import com.mysite.customer.model.LegalCustomer;
import com.mysite.customer.model.RealCustomer;
import com.mysite.customer.service.CustomerService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI  implements AutoCloseable{
    private final Scanner scanner;
    private final CustomerService customerService;
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        customerService=CustomerService.getInstance();
    }
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
                    editCustomerById();
                    break;
                case 6:
                    deleteCustomerById();
                    break;
                case 7:
                    printAllDeletedCustomers();
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
        System.out.println("2. Print Active Customers");
        System.out.println("3. Search and print customer by name");
        System.out.println("4. Search and print customer by family");
        System.out.println("5. Edit customer by id");
        System.out.println("6. Delete customer by id");
        System.out.println("7. Print deleted customers");
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
        List<Customer> allCustomers = customerService.getActiveCustomers();
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
    private void printAllDeletedCustomers() {
        List<Customer> allCustomers = customerService.getDeletedCustomers();
        if(allCustomers.isEmpty()){
            System.out.println("There is no deleted Customers ");
        }
        else {
            System.out.println("All Deleted Customers:");
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
    private void editCustomerById() {
        String id = getUserInput("Enter id:");
       Customer customer=customerService.getCustomerById(Integer.valueOf(id));

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
                System.out.println(customer);
            }

    private void deleteCustomerById() {
        String id = getUserInput("Enter Id:");
       customerService.deleteCustomersById(Integer.valueOf(id));
    }
    }

