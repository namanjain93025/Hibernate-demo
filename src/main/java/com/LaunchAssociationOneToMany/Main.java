package com.LaunchAssociationOneToMany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = null;
        Transaction transaction;
        try{
             session   =  sessionFactory.openSession();
             transaction= session.beginTransaction();

//             QuestionTable  q1 =new QuestionTable();
//             q1.setQuestion("What is hibernate ? ");
//             AnswerTable a1 = new AnswerTable();
//             AnswerTable a2 = new AnswerTable();
//             a1.setAnswer(" hibernate is an orm framework ");
//             a2.setAnswer("Hibernate is used for db query");
//             a1.setQuestion(q1);
//             a2.setQuestion(q1);
//            List<AnswerTable>list = new ArrayList<>();
//            list.add(a1);
//            list.add(a2);
//            q1.setAnswers(list);
//            session.persist(q1);
//            transaction.commit();

            QuestionTable questionTable =session.find(QuestionTable.class,1);
            System.out.println("question : "+questionTable.getQuestion());
            System.out.println("answer   : ");
            questionTable.getAnswers().forEach((o)->System.out.println(o.getAnswer()));
        }catch (HibernateException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
