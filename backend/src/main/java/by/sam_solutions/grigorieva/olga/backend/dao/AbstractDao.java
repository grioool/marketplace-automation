package by.sam_solutions.grigorieva.olga.backend.dao;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractDao<T extends Serializable> {

    private final Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    protected AbstractDao() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(@NotNull T entity) {
        getSession().save(entity);
    }

    public T getById(Integer id) {
        return getSession().get(clazz, id);
    }

    public List<T> getAll() {
        return getSession().createQuery("from " + clazz.getName(), clazz).list();
    }

    public T update(@NotNull T entity) {
        return (T) getSession().merge(entity);
    }

    public void delete(@NotNull T entity) {
        getSession().delete(entity);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
