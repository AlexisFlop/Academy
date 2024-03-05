package com.academy.apiacademy.Services.service_implementations;

import java.lang.reflect.Method;
import java.util.List;

import com.academy.apiacademy.Exceptions.ModelNotFoundException;
import com.academy.apiacademy.Repositories.iGenericRepository;
import com.academy.apiacademy.Services.iCRUD;

public abstract class CRUDimplementation<T, ID> implements iCRUD<T, ID>{

    protected abstract iGenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) throws Exception {
        return getRepository().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        Class<?> tClass = t.getClass();
        String className = tClass.getSimpleName();
        String methodNamme = "setId" + className;

        Method setIdMethod = tClass.getMethod(methodNamme, id.getClass());

        setIdMethod.invoke(t, id);
        
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND:" + id));
        return getRepository().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND:" + id));
        getRepository().deleteById(id);
    }

    @Override
    public T getById(ID id) throws Exception {
        return getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND:" + id));
    }

    @Override
    public List<T> getAll() throws Exception {
        return getRepository().findAll();
    }


    
}
