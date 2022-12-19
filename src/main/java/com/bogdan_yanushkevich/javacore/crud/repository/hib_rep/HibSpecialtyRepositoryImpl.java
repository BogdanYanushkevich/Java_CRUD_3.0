package com.bogdan_yanushkevich.javacore.crud.repository.hib_rep;

import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.SpecialtyRepository;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.bogdan_yanushkevich.javacore.crud.repository.hib_rep.HibConnection.openSession;


public class HibSpecialtyRepositoryImpl implements SpecialtyRepository {

    public HibSpecialtyRepositoryImpl() {
    }
    Transaction transaction;


    public Specialty create(Specialty specialty) {

        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            specialty.setStatus(Status.ACTIVE);
            session.persist(specialty);
            Long id = (Long) session.getIdentifier(specialty);
            session.getTransaction().commit();
            specialty.setId(id);
            return specialty;
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public Specialty read(Long id) {
        Specialty specialty;
        try (Session session = openSession()) {
            specialty = session.get(Specialty.class, id);
        }
        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.merge(specialty);
            session.getTransaction().commit();
            return specialty;
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
            Specialty specialty = session.get(Specialty.class, id);
            specialty.setStatus(Status.DELETED);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<Specialty> getALl() {
        List<Specialty> specialties;

        try (Session session = openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Specialty> query = builder.createQuery(Specialty.class);
            query.from(Specialty.class);
            specialties = session.createQuery(query).getResultList();
        }
        return specialties;
    }
}
