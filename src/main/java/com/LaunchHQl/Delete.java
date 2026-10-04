package com.LaunchHQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Delete {
    public  static  void main(String[] args){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try{
            //Bulk retrival of data and Update *****************************************
            //***************************************************************

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<String> query = session.createQuery("DELETE  Teacher  WHERE name in (:Name1 , :Name2)");
            query.setParameter("Name1", "Akansha Patel");
            query.setParameter("Name2", "Dilip Dubey");

            int  n  = query.executeUpdate();
            if(n>0){
                System.out.println("rows updated "+n);
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.close();;
            sessionFactory.close();
        }
    }

}
