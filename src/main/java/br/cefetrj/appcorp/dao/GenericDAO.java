package br.cefetrj.appcorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.cefetrj.appcorp.config.HibernateConfig;
import br.cefetrj.appcorp.model.GenericEntity;
public abstract class GenericDAO<T extends GenericEntity> {

    protected org.hibernate.SessionFactory sessionFactory;
    public GenericDAO() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
   
    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao criar entidade", e);
        }
    }

    public abstract Class<T> getEntityClass();
   
    public List<T> getAll() {
        Session session = sessionFactory.openSession();
       
        List<T> entities = session.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).list();
        session.close();
        return entities;
    }

    public T getById(Long id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(getEntityClass(), id);
        session.close();
        return entity;
    }
    
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao atualizar entidade", e);
        }
        
    }
    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao excluir entidade", e);
        }
    }
}