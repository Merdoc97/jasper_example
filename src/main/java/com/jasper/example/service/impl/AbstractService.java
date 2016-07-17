package com.jasper.example.service.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Artyomov.I
 * abstract service for common operations
 */

@Transactional
public class AbstractService<T> {
    private final CrudRepository<T, Number> repository;

    public AbstractService(CrudRepository<T, Number> repository) {
        this.repository = repository;
    }

    /**
     *
     * @return entity which registered in repository
     */
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return (List<T>) repository.findAll();
    }

    /**
     *
     * @param id entity id in repository
     * @return entity registered in repository
     */
    @Transactional(readOnly = true)
    public T getById(Number id){
        return repository.findOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public T update(T entity){
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Number entityId){
        repository.delete(entityId);
    }
}
