package com.LaunchDataRetrival;

import com.Launch.model.Employee;
import com.LaunchHibernate.Aline;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/// level  2 caching using empl class
public class GetRecord2Lev2Caching {
    public static void main(String[] args){
      SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClasses(Employee.class).buildSessionFactory();
        Session session1 = null;
        Session session2 = null;
        try{
            session1 = sessionFactory.openSession();
            session2 = sessionFactory.openSession();

            Employee e1 = session1.find(Employee.class, 101);//eager loading
            Employee e2 = session1.find(Employee.class, 101);//eager loading

            System.out.println(e1);
            System.out.println(e2);

            Employee e3 = session2.find(Employee.class, 101);//eager loading
            Employee e4 = session2.find(Employee.class, 101);//eager loading

            System.out.println(e3);
            System.out.println(e4);

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

    }

}
