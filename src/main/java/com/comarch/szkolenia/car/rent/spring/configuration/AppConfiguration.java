package com.comarch.szkolenia.car.rent.spring.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("com.comarch.szkolenia.car.rent.spring")
public class AppConfiguration {

    @Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/car-rent", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Sterownik sie wywalil !!");
        } catch (SQLException e) {
            System.out.println("Nie dziala polaczenie do bazy !!");
        }

        return null;
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}
