package com.LaunchHQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public  static  void main(String[] args){

       SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
//        Transaction transaction = null;
        try{
            //Bulk retrival of data *****************************************
            //***************************************************************

            session = sessionFactory.openSession();
//            Query<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
//            Query<Teacher> query = session.createQuery("FROM Teacher where name=:Name", Teacher.class);
//            Query<String> query = session.createQuery("SELECT subject FROM Teacher WHERE name=:Name");
            Query<String> query = session.createQuery("SELECT subject FROM Teacher WHERE name in (:Name1 , :Name2)");
            query.setParameter("Name1", "Akansha Patel");
            query.setParameter("Name2", "Dilip Dubey");
            List<String> list = query.list();
            list.forEach(o->System.out.println(o));

//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            Teacher t1 = new Teacher();
//            t1.setName("Dilip Dubey");
//            t1.setSubject("Hindi");
//
//            Teacher t2 = new Teacher();
//            t2.setName("Suman Lata bist");
//            t2.setSubject("English");
//
//            Teacher t3 = new Teacher();
//            t3.setName("Suman bali");
//            t3.setSubject("English");
//
//            Teacher t4= new Teacher();
//            t4.setName("Akansha Patel");
//            t4.setSubject("Sst");
//
//            session.persist(t1);
//            session.persist(t2);
//            session.persist(t3);
//            session.persist(t4);
//
//            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
            session.close();;
            sessionFactory.close();
        }
    }

}
