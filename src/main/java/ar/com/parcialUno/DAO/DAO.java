package ar.com.parcialUno.DAO;

import java.util.List;

public interface DAO<T> {
    void create(T entity);
    List<T> getAll();
    void update(int id, T entity);
    void delete(int id, T entity);
    T getById(int id);

}
