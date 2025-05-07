package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Student s = new Student("Chris");

        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        session.close();

        System.out.println("Student saved successfully");
    }
}
