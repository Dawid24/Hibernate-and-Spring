package com.paciorek.dawid;

import com.paciorek.dawid.model.Customer;
import com.paciorek.dawid.model.CustomerB2B;
import com.paciorek.dawid.services.ICustomerB2BService;
import com.paciorek.dawid.services.ICustomerService;
import com.paciorek.dawid.services.IHibernateSessionFactoryService;
import com.paciorek.dawid.services.impl.CustomerB2BService;
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

        CustomerB2B customerB2B = new CustomerB2B();
        customerB2B.setCompanyName("4F");
        customerB2B.setNip("7839958302");
        customerB2B.setRegon("F-3454-AHG");
        customerB2B.setFax("3445679852");

        customerService.saveCustomer(customer);
        Customer customerFromDB = customerService.getCustomerById(1);
        System.out.println(customerFromDB);

        ICustomerB2BService customerB2BService = new CustomerB2BService(hibernateSessionFactoryService);
        customerB2BService.saveCustomerB2B(customerB2B);
        CustomerB2B customerB2BFromDB = new CustomerB2B();
        customerB2BService.getCustomerById(1);
        System.out.println(customerB2B);

        System.exit(0);
    }
}
