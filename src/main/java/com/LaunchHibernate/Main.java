package com.LaunchHibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Aline al = new Aline();
        al.setAid(10);
        al.setName("Aman");
        al.setTech("Java");
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.LaunchHibernate.Aline.class);

        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(al);//persist is save
        transaction.commit();
        session.close();
//        sessionFactory.close();
    }
}