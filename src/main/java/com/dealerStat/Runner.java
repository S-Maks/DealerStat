package com.dealerStat;

import com.dealerStat.models.Comment;
import com.dealerStat.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "12345");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Comment.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        // Comment user = session.createQuery("from Comment comment ",Comment.class).getSingleResult();
        // System.out.println(user);
        User user = session.createQuery("from User user", User.class).getSingleResult();
        System.out.println(user);
    }
}