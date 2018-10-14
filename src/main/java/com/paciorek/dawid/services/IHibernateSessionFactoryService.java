package com.paciorek.dawid.services;

import org.hibernate.Session;

public interface IHibernateSessionFactoryService {
    Session getSession();
}
