package com.paciorek.dawid.services;

import com.paciorek.dawid.model.CustomerB2B;

public interface ICustomerB2BService {
    void saveCustomerB2B(CustomerB2B customerB2B);
    CustomerB2B getCustomerById(int id);
}
