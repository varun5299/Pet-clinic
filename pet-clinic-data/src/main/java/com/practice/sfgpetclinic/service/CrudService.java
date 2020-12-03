package com.practice.sfgpetclinic.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}

