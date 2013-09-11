package br.com.mrg.dbtracemodel.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;

import org.hibernate.Session;

public class DefaultRepository<T> implements IDefaultRepository<T> {

    private Class<T> type;
    
    @PersistenceContext(unitName = "DBTracePU")
    private EntityManager entityManager;

    public DefaultRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T findById(Long id) {
        return this.entityManager.find(this.type, id);
    }

    @Override
    public T findById(String id) {
        return this.entityManager.find(this.type, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return createSession().createCriteria(this.type).list();
    }

    public void delete(Object object) {
        this.entityManager.remove(object);
    }

    @Override
    public void create(Object object) {
        this.entityManager.persist(object);
    }

    @Override
    public void update(Object object) {
        this.entityManager.merge(object);
    }

    protected Session createSession() {
        return (Session) this.entityManager.getDelegate();
    }
    
    protected Criteria createCriteria() {
        return createSession().createCriteria(this.type);
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public T getReference(Long id) {
        return this.getEntityManager().getReference(this.type, id);
    }
}