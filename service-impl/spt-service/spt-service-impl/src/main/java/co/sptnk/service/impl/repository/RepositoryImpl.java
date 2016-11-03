package co.sptnk.service.impl.repository;

import co.sptnk.service.impl.persistence.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by evseevvd on 02.11.16.
 */
public abstract class RepositoryImpl<E extends BaseEntity> implements Repository<E> {

    private final Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    protected RepositoryImpl(Class<? extends BaseEntity> entityClass) {
        this.entityClass = (Class<E>) entityClass;
    }

    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public E read(Serializable id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public void remove(E entity) {
        //иначе будет пытаться удалить неприатаченную сущность
        E forDelete = entityManager.contains(entity) ? entity : entityManager.merge(entity);
        entityManager.remove(forDelete);
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public void clear() {
        entityManager.clear();
    }

    @Override
    public void refresh(E entity) {
        entityManager.refresh(entity);
    }
}
