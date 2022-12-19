package com.bogdan_yanushkevich.javacore.crud.repository.hib_rep;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.SkillRepository;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.bogdan_yanushkevich.javacore.crud.repository.hib_rep.HibConnection.*;


public class HibSkillRepositoryImpl implements SkillRepository {
    Transaction transaction;

    public HibSkillRepositoryImpl() {
    }

    public Skill create(Skill skill) {

        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            skill.setStatus(Status.ACTIVE);
            session.persist(skill);
            Long id = (Long) session.getIdentifier(skill);
            session.getTransaction().commit();
            skill.setId(id);
            return skill;
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public Skill read(Long id) {
        Skill skill;
        try (Session session = openSession()) {
            skill = session.get(Skill.class, id);
        }
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.merge(skill);
            session.getTransaction().commit();
            return skill;
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
            Skill skill = session.get(Skill.class, id);
            skill.setStatus(Status.DELETED);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<Skill> getALl() {
        List<Skill> skills;

        try (Session session = openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Skill> query = builder.createQuery(Skill.class);
            query.from(Skill.class);
            skills = session.createQuery(query).getResultList();
        }
        return skills;
    }
}

