package com.bogdan_yanushkevich.javacore.crud.repository.hib_rep;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;

import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.DeveloperRepository;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.bogdan_yanushkevich.javacore.crud.repository.hib_rep.HibConnection.*;


public class HibDeveloperRepositoryImpl implements DeveloperRepository {
    Transaction transaction;

    public HibDeveloperRepositoryImpl() {
    }

    public Developer create(Developer developer) {

        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            developer.setStatus(Status.ACTIVE);
            session.persist(developer);
            Long id = (Long) session.getIdentifier(developer);
            session.getTransaction().commit();
            developer.setId(id);
            return developer;
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public Developer read(Long id) {
        Developer developer;
        try (Session session = openSession()) {
            developer = session.get(Developer.class, id);
        }
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.merge(developer);
            session.getTransaction().commit();
            return developer;
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            Developer developer = session.get(Developer.class, id);
            developer.setStatus(Status.DELETED);
            session.merge(developer);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<Developer> getALl() {
        List<Developer> developers;

        try (Session session = openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Developer> query = builder.createQuery(Developer.class);
            query.from(Developer.class);
            developers = session.createQuery(query).getResultList();
        }
        return developers;
    }
}