package com.hib;

import com.hib.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateApp
{
    public static void main(String[] args)
    {
        try (SessionFactory sessionFactory = HibernateUtils.buildSessionFactory())
        {
            String hql = "FROM Country";

            Session session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();

            Query<Country> countryQuery = sessionFactory.getCurrentSession().createQuery(hql);
            List<Country> countries = countryQuery.getResultList();

            for (Country country: countries)
            {
                System.out.println(country.getCountryId() + "" + country.getCountryName());
            }
        }

    }
}
