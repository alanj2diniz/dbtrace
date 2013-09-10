package br.com.mrg.dbtracemodel.repository;

import java.util.List;

public interface IDefaultRepository<T> {

    T findById(Long id);

    T findById(String id);

    List<T> findAll();

    void delete(Object object);

    void create(Object object);

    void update(Object object);

    T getReference(Long id);
}