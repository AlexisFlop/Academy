package com.academy.apiacademy.Services.service_implementations;

import org.springframework.stereotype.Service;

import com.academy.apiacademy.Models.Tuition;
import com.academy.apiacademy.Repositories.iGenericRepository;
import com.academy.apiacademy.Repositories.iTuitionRepository;
import com.academy.apiacademy.Services.iTuitionService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TuitionImplementation extends CRUDimplementation<Tuition, Integer> implements iTuitionService{
        
            private final iTuitionRepository repository;
            @Override
            protected iGenericRepository<Tuition, Integer> getRepository() {
                return repository;
            }  
}
