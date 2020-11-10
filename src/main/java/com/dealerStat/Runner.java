package com.dealerStat;

import com.dealerStat.models.Comment;
import com.dealerStat.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.metamodel.EntityType;

import java.io.File;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/DealerStat");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "12345");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Comment.class);
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        //Comment comment = session.createQuery("from Comment comment", Comment.class).getSingleResult();
        //System.out.println(comment);

        User user = session.createQuery("from User user where user.id = 2",User.class).getSingleResult();
        System.out.println(user);
        User test = new User("Rita","Prokhozhaya","1208","prokhozhaya@gmail.com");
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        //User TestDelete = session.createQuery("from User user where user.id = 3", User.class).getSingleResult();
        //session.beginTransaction();
        //session.delete(TestDelete);
        //session.getTransaction().commit();
        User TestUpdate = session.createQuery("from User user where user.firstName = 'Rita'", User.class).getSingleResult();
        TestUpdate.setLastName("Titok");
        session.beginTransaction();
        session.update(TestUpdate);
        session.getTransaction().commit();

    }
}