package com.LaunchLob;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session= null;
        Transaction transaction =null;
        FileInputStream file = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            StudentInfo s1 = new StudentInfo();
            s1.setCity("Delhi");
            s1.setName("Ram");
            //now i want to store fil
             file = new FileInputStream("C:\\Users\\naman\\OneDrive\\Pictures\\Screenshots\\Screenshot 2025-09-07 122620.png");
             byte [] image = new byte[file.available()];
             file.read(image);
             //now read file
            File file1 = new File("C:\\Users\\naman\\Desktop\\NotePad1.txt");
            FileReader reader = new FileReader(file1);
            char[]textFile = new char[(int)file1.length()];
            reader.read(textFile);

            s1.setTextFile(textFile);
            s1.setImage(image);
              session.persist(s1);
            transaction.commit();

            file.close();
            reader.close();

        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {


            session.close();
            sessionFactory.close();
        }
    }

}
