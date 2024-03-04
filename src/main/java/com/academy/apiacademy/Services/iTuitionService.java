package com.academy.apiacademy.Services;

import java.util.List;
import java.util.Map;

import com.academy.apiacademy.Models.Student;
import com.academy.apiacademy.Models.Tuition;

public interface iTuitionService extends iCRUD<Tuition, Integer>{

    Map<String, List<Student>> getStudentsBySession();
    
}
