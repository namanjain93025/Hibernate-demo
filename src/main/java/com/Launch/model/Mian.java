package com.Launch.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mian {
    public  static  void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = null;
        Transaction transaction =null;
        boolean flag =false;
        try{
            session = sessionFactory.openSession();
            Employee e = new Employee();
            e.setEage(12);
            e.seteCity("Indore");
            e.setEid(101);
            e.seteName("Ramu");
            transaction = session.beginTransaction();
            session.persist(e);
            flag =true;
        }catch (Exception e){

        }finally {
            if(flag){
                transaction.commit();
            }else transaction.rollback();

            session.close();
            sessionFactory.close();
        }

    }

}
