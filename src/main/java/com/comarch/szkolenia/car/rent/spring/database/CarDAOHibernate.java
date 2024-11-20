package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.Car;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarDAOHibernate implements CarRepositoryInterface {

    private final SessionFactory sessionFactory;

    public CarDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Car> getCars() {
        Session session = this.sessionFactory.openSession();
        Query<Car> query = session.createQuery("FROM com.comarch.szkolenia.car.rent.spring.model.Car", Car.class);

        List<Car> result = query.getResultList();
        session.close();
        return result;
    }

    public Optional<Car> getGyId(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Car> query = session.createQuery(
                "FORM com.comarch.szkolenia.car.rent.spring.model.Car WHERE id = :id", Car.class);
        query.setParameter("id", id);

        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    public void persist(Car car) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public void update(Car car) {
        Session session = this.sessionFactory.openSession();
        try {
            session.getTransaction();
            session.merge(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
