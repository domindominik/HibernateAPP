package com.hib;

import com.hib.sep.Book;
import com.hib.sep.Student;
import com.hib.sep.enums.Sex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Struct;
import java.util.List;

public class StudentApp2
{
    public static void main(String[] args)
    {


        try(SessionFactory sessionFactory = HibernateUtils.buildSessionFactory())
        {
            Session session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();

           // session.save(student);

            String hql= "Select s from Student s";

            Query<Student> querry = session.createQuery(hql);
            List<Student> result = querry.getResultList();


            Student student = result.get(0);

            Book book = new Book();
            book.setAuthor("tacos");
            book.setTitle("hemingway");
            book.setPage(821);
            book.setStudent(student);

            Book book2 = new Book();
            book2.setAuthor("Lem");
            book2.setTitle("stalin");
            book2.setPage(451);
            book2.setStudent(student);

/*            Student student = new Student();
            student.setName("laura");
            student.setSurname("blondynka");
            student.setIndexNumber(19450L);
            student.setSex(Sex.FEMALE);
            session.save(student);*/
            session.save(book);
            session.save(book2);
            session.getTransaction().commit();
            session.close();
        }
    }
}
