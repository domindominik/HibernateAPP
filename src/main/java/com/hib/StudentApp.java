package com.hib;

import com.hib.sep.Student;
import com.hib.sep.enums.Sex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentApp
{
    public static void main(String[] args)
    {
        Student student = new Student();
        student.setName("laura");
        student.setSurname("brunetka");
        student.setIndexNumber(12450L);
        student.setSex(Sex.FEMALE);

        try(SessionFactory sessionFactory = HibernateUtils.buildSessionFactory())
        {
            Session session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();

            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
    }
}
