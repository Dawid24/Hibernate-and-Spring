package com.paciorek.dawid.services.impl;

import com.paciorek.dawid.model.CustomerB2B;
import com.paciorek.dawid.services.ICustomerB2BService;
import com.paciorek.dawid.services.IHibernateSessionFactoryService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerB2BService implements ICustomerB2BService {

    IHibernateSessionFactoryService sessionFactoryService;

    public CustomerB2BService(IHibernateSessionFactoryService sessionFactoryService) {
        this.sessionFactoryService = sessionFactoryService;
    }

    @Override
    public void saveCustomerB2B(CustomerB2B customerB2B) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customerB2B);
        transaction.commit();
        session.close();
    }

    @Override
    public CustomerB2B getCustomerById(int id) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerB2B> query = criteriaBuilder.createQuery(CustomerB2B.class);
        Root<CustomerB2B> root = query.from(CustomerB2B.class); //wyciaganie mapowanie
        query.select(root).where(criteriaBuilder.equal(root.get("id"), id)); //robimy selecta po mapowaniu na polu id zmapowane w tabelce
        Query<CustomerB2B> q = session.createQuery(query);
        CustomerB2B customerB2B = q.getSingleResult();

        transaction.commit();
        session.close();
        return customerB2B;
    }
}
