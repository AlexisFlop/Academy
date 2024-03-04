package com.academy.apiacademy.Services.service_implementations;

import org.springframework.stereotype.Service;

import com.academy.apiacademy.Models.Session;
import com.academy.apiacademy.Repositories.iGenericRepository;
import com.academy.apiacademy.Repositories.iSessionRepository;
import com.academy.apiacademy.Services.iSessionService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class SessionImplementation extends CRUDimplementation<Session, Integer> implements iSessionService{
    
        private final iSessionRepository repository;
        @Override
        protected iGenericRepository<Session, Integer> getRepository() {
            return repository;
        }
    
}
