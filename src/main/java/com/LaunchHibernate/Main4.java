package com.LaunchHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main4 {
    public static void main(String[] args){
        Configuration config = null;
        SessionFactory sessionFactory= null;
        Session session = null;
        Transaction transaction =null;

        config =new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        Aline a = new Aline();
        a.setName("Ramesh");
        a.setAid(201);
        a.setTech("PERN");
        boolean flag = false;
        try{
            transaction = session.beginTransaction();
            session.merge(a);
            flag = true;
        }catch (HibernateException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(flag){
                transaction.commit();
            }else{
                transaction.rollback();
            }

            session.close();;
            sessionFactory.close();
        }

    }
}
