package com.paciorek.dawid;

import com.paciorek.dawid.model.Customer;
import com.paciorek.dawid.services.ICustomerService;
import com.paciorek.dawid.services.IHibernateSessionFactoryService;
import com.paciorek.dawid.services.impl.CustomerService;
import com.paciorek.dawid.services.impl.HibernateSessionFactoryService;

public class Main {
    public static void main(String[] args) {

        IHibernateSessionFactoryService hibernateSessionFactoryService = new HibernateSessionFactoryService();
        ICustomerService customerService = new CustomerService(hibernateSessionFactoryService);

        Customer customer = new Customer();
        customer.setName("Dawid");
        customer.setSurname("Paciorek");
        customer.setPhone("123567843");

        customerService.saveCustomer(customer);
        Customer customerFromDB = customerService.getCustomerById(1);
        System.out.println(customerFromDB);
    }
}
