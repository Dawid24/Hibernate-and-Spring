package com.paciorek.dawid.services;

import com.paciorek.dawid.model.Customer;

public interface ICustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(int id);
}
