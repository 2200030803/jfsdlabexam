package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertInitialData {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Insert initial data
        Department department = new Department();
        department.setName("IT");
        department.setLocation("Block A");
        department.setHodName("Dr. Smith");

        session.save(department);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
