package br.cefetrj.appcorp.dao;

import java.util.List;
import br.cefetrj.appcorp.model.GenericEntity;
public abstract class GenericDAO<T extends GenericEntity> {
    public void create(T entity) {
    }
    public List<T> getAll() {
        return null;
    } 
    public T getById(Long id) {
        return null;
    }
    public void update(T entity) {
    }
    public void delete(T entity) {
    }
}