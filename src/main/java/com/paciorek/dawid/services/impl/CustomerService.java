package com.paciorek.dawid.services.impl;

import com.paciorek.dawid.model.Customer;
import com.paciorek.dawid.services.ICustomerService;
import com.paciorek.dawid.services.IHibernateSessionFactoryService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerService implements ICustomerService {

    private IHibernateSessionFactoryService sessionFactoryService;

    public CustomerService(IHibernateSessionFactoryService sessionFactoryService) {
        this.sessionFactoryService = sessionFactoryService;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer getCustomerById(int id) {
        //zamiast stringa from...
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", id));
        Customer customer = (Customer) criteria.uniqueResult();

        //criteria.add(Restrictions.gt("phone", "1"));
        transaction.commit();
        session.close();
        return customer;
    }
}
