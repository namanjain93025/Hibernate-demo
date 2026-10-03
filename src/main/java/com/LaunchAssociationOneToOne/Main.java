package com.LaunchAssociationOneToOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Question q1 = new Question();
            q1.setQuestion("What is hibernate ? ");

            Answer a1= new Answer();
            a1.setAnswer("hibernate is an orm frameWork");
            q1.setAnswer(a1);
            a1.setQuestion(q1);

            Question q2 = new Question();
            q2.setQuestion("What is jpa ? ");

            Answer a2= new Answer();
            a2.setAnswer("jpa , jakarta persistance api");
            q2.setAnswer(a2);
            a2.setQuestion(q2);

            session.persist(q1);
//            session.persist(q2);
            session.persist(a2);

            transaction.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
