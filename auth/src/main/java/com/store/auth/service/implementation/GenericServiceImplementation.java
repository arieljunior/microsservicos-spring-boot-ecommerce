package com.store.auth.service.implementation;

import com.store.auth.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class GenericServiceImplementation<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T> {
    protected final R repository;

    public GenericServiceImplementation(R repository){
        this.repository = repository;
    }

    @Override
    public List<T> getAll(){
        return repository.findAll();
    }

    @Override
    public T get(Long id, String noSuchElementException){
        return repository.findById((ID) id).orElseThrow(() -> new NoSuchElementException((noSuchElementException + id)));
    }

    @Override
    public void save(T entity){
        repository.save(entity);
    }

    @Override
    public void update(T entity){
        repository.save(entity);
    }

    @Override
    public void delete(Long id){
        repository.deleteById((ID) id);
    }
}
