package com.academy.apiacademy.Services.service_implementations;

import org.springframework.stereotype.Service;

import com.academy.apiacademy.Models.Student;
import com.academy.apiacademy.Services.iStudentService;
import com.academy.apiacademy.Repositories.iGenericRepository;
import com.academy.apiacademy.Repositories.iStudentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StudentImplementation extends CRUDimplementation<Student, Integer> implements iStudentService{

    private final iStudentRepository repository;
    @Override
    protected iGenericRepository<Student, Integer> getRepository() {
        return repository;
    }
}
