package com.LaunchDataRetrival;

import com.LaunchHibernate.Aline;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/// */*
/// Lazy  loading , eager loading , level-1 caching
/// */
public class GetRecord {
    public  static  void main(String[] args){
        SessionFactory sessionFactory =new Configuration().configure().addAnnotatedClasses(Aline.class).buildSessionFactory();
        Session session1 = null;
        Session session2 = null;
        try{
            session1 = sessionFactory.openSession();
            session2 = sessionFactory.openSession();
//            Aline aline = session.find(Aline.class, 101);

//           session.load(Aline.class,101);
//            Aline a = session.getReference(Aline.class, 101);//lazy loading
            Aline aline1 = session1.find(Aline.class, 101);//eager loading
            Aline aline2 = session1.find(Aline.class, 101);//eager loading

            System.out.println(aline1);
            System.out.println(aline2);

            Aline aline3 = session2.find(Aline.class, 101);//eager loading
            Aline aline4 = session2.find(Aline.class, 101);//eager loading

            System.out.println(aline3);
            System.out.println(aline4);

        }catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            session1.close();
            session2.close();
            sessionFactory.close();;
        }
        ///

    }
}
