package com.academy.apiacademy.Services.service_implementations;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import com.academy.apiacademy.Models.Student;
import com.academy.apiacademy.Models.Tuition;
import com.academy.apiacademy.Models.TuitionDetail;
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

            @Override
            public Map<String, List<Student>> getStudentsBySession() {
                Stream<Tuition> tuitions = repository.findAll().stream();
                Stream<List<TuitionDetail>> tuitionDetails = tuitions.map(Tuition::getTuitionDetails);

                Stream<TuitionDetail> tuitionDetail = tuitionDetails.flatMap(Collection::stream);
                Map<String,List<Student>> studentsBySession = tuitionDetail.collect(groupingBy(d -> d.getSession().getName(),
                mapping(TuitionDetail::getTuition, mapping(Tuition::getStudent, toList()))));

                return studentsBySession;
            }  
}
