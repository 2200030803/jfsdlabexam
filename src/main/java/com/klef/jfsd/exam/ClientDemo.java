package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Example: Update department name and location using positional parameters
        String hql = "UPDATE Department SET name = :newName, location = :newLocation WHERE id = :departmentId";
        Query query = session.createQuery(hql);
        query.setParameter("newName", "Updated Department Name");
        query.setParameter("newLocation", "Updated Location");
        query.setParameter("departmentId", 1L); // Assuming department with ID 1 exists

        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
