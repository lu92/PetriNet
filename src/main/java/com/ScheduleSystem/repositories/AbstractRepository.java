package com.ScheduleSystem.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

/**
 * Created by SG0222895 on 8/7/2015.
 */
@Repository
public abstract class AbstractRepository<T extends Serializable, ID extends Serializable>
{
    private Class<T> type;
    private SessionFactory sessionFactory;

    public AbstractRepository()
    {
    }

    public AbstractRepository(SessionFactory sessionFactory)
    {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.sessionFactory = sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }


    public T save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T entityDb = null;
        try
        {
            entityDb = (T) session.save(entity);
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
        finally
        {
            session.close();
        }
        return entityDb;
    }
    public Optional<T> get(ID id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T entityDb = null;
        try
        {
            entityDb = (T) session.get(type, id);
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
        finally
        {
            session.close();
            return Optional.of(entityDb);
        }
    }
    public void remove(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(entity);
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
        finally
        {
            session.close();
        }
    }

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T entityDb = null;
        try
        {
            session.saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
        finally
        {
            session.close();
        }
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<T> all = null;
        try
        {
            all  = session.createQuery("from " + type.getName()).list();
            transaction.commit();
        } catch (TransactionException e) {
            transaction.rollback();
        }
        finally
        {
            session.close();
        }
        return all;
    }

    public long count() {
        return findAll().size();
    }
}
