package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory;

    static {

        try {

            factory = new Configuration()
                    .configure()
                    .buildSessionFactory();

            System.out.println("Hibernate Started");

        } catch (Throwable ex) {

            System.out.println("Hibernate Error");
            ex.printStackTrace();

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}