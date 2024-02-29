package com.academy.apiacademy.Services;

import java.util.List;

public interface iCRUD<T, ID> {
    T save(T t) throws Exception;
    T update(T t, ID id) throws Exception;
    void delete(ID id) throws Exception;
    T getById(ID id) throws Exception;
    List<T> getAll() throws Exception;   
}