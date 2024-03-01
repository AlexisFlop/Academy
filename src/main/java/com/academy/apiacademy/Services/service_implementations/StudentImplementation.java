package com.academy.apiacademy.Services.service_implementations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<Student> orderStudentsDescByAge() {
        List<Student> students = repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
        return students;
    }
}
