package br.cefetrj.appcorp.service;

import java.time.LocalDate;
import java.util.List;

import br.cefetrj.appcorp.dao.GenericDAO;
import br.cefetrj.appcorp.model.GenericEntity;

public abstract class GenericService<T extends GenericEntity> {
    protected GenericDAO<T> dao;

    public GenericService(GenericDAO<T> dao) {
        this.dao = dao;
    }
    public void create(T entity) {
        entity.setDataCadastro(LocalDate.now());
        entity.setDataUltimaAlteracao(LocalDate.now());
        dao.create(entity);
    }
    public List<T> getAll() {
        return dao.getAll();
    }
    public T getById(Long id) {
        return dao.getById(id);
    }
    public void update(T entity) {
        entity.setDataUltimaAlteracao(LocalDate.now());
        dao.update(entity);
    }
    public void delete(T entity) {
        dao.delete(entity);
    }
}